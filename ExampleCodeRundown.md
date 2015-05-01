# Introduction #
This document gives you a rundown of the example code which can be installed here [InstallExample](InstallExample.md).

The example code is separated into three different projects: tools, img-thumbnailer and thumbnails.

  * The tools project contains the latest version of the @ProviderFor annotation and its processor.
  * The thumbnails project contains the main program, which employs service providers as renderers for different file types, so it can be easily extended with new file types.
  * The img-thumbnailer project contains our example service provider, which creates thumbnails of images and makes use of the @ProviderFor annotation

# Code #
## thumbnails ##
### [ThumbnailRenderer](http://code.google.com/p/spi/source/browse/trunk/examples/thumbnails/src/org/mangosdk/spi/examples/thumbnails/spi/ThumbnailRenderer.java) ###
This is the actual service provider interface of our example program. It contains methods to check whether a file is compatible, render a thumbnail of a file and to provide a description of the renderer.

### [Thumbnailer](http://code.google.com/p/spi/source/browse/trunk/examples/thumbnails/src/org/mangosdk/spi/examples/thumbnails/Thumbnailer.java) ###
This is the actual program that finds all service providers for the ThumbnailRenderer service provider interface and uses them to render thumbnails of the files specified.

The service provided by the program is the creation of thumbnails of provided files.
#### main ####
The main method first checks whether any filenames were supplied to the program and if not, it prints a message telling the user to supply the program with filenames.

If it has gotten any filenames it will call the renderThumbNail(String) for each filename.

#### renderThumbNail ####
This method first checks if the file with the given name exists and is readable. If this is the case it calls findRenderer to try to find a service provider that accepts the file for its render method.

If a renderer has been found it tries to render the file in a general try-catch block so any possible error thrown by a provider can be caught. Since there is no control over what kind of renderers the user will add to the program it has to catch all errors here, otherwise users could break the program from the outside, which is highly undesireable.

Finally it will call the writeImage method to write the thumbnail.

#### writeImage ####
This method writes the rendered image to a file. This is of course done within a try-catch block to catch possible IO Errors. The actual writing of the file is done within a try-finally block embedded in that try-catch block to make sure the FileOutputStream is closed.

#### findRenderer ####
This is where the real magic happens. The method employs the ServiceLoader#load(Class) method to get an iterator of all available ThumbnailRenderer service providers. It then iterates over all found renderers and the first one that accepts the file through its accept(File) method is returned.

The reason it does not directly iterate over the ServiceLoader is as following. The loading of service provider is dependent of the correct implementation of each service provider its provider-configuration file. Now if one of those would be configured faulty it would crash the whole program. However, because the service providers are loaded lazily, seperating the iteration from the actual loading allows the catch each ServiceConfigurationError individually which allows the program to continue normally with all available properly configured service providers

## img-thumbnailer ##
### [ImgThumbnailRenderer](http://code.google.com/p/spi/source/browse/trunk/examples/img-thumbnailer/src/org/mangosdk/spi/examples/img_thumbnailer/ImgThumbnailRenderer.java) ###
This is the implementation of the ThumbnailRenderer service provider interface.

Most notably it uses the @ProviderFor annotation to flag it as a service provider for the ThumbnailRenderer. This makes sure the service provider will be found by the program. Additionally, it will tell our annotation processor to check the class for possible SPI-related errors during compile time, which prevents hard to track down bugs during run time, which is nice.

As can be read in the getDescription() implementation it is meant for ordinary image files
As such it accepts files with the extensions png, jpg and gif.

This implementation of the render(File) reads the original image, creates a new image sized 75 by 100 pixels. It then draws the old image in the new image and returns the result, which is essentially a thumbnail of the original file.