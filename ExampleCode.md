# The Example Code #

This project also contains an example of the usage of a Service Provider Interface and how to use the @ProviderFor annotation to ease development.

## Installing the example code ##

InstallExample explains how to get the example code on your machine.

## Using the example code ##

### In Eclipse ###
The projects come tailor made for use in eclipse, so just run the Thumbnailer launch target and the program will execute.

### Command line ###
If you checked the program out via command line svn or downloaded the source archive the easiest way to compile the example is using Apache Ant. If you do not have it installed you can get it at http://ant.apache.org/. The thumbnails directory contains an ant build file which can be used to compile the source code in one go.

Once all the files have been compiled you can run the program using
```
java -cp <classpath_containing_implementations_of_renderers> Thumbnailer <file_1> [<file_2>...<file_n>] 
```

### Result ###
Whichever method you run the program, if all has gone correctly the standard output (Console) will receive:
> Using renderer 'Renderer for ordinary image files' for 'sample-image.jpg' <br>
<blockquote>Successfully created 'sample-image.jpg-thumb.png' for 'sample-image.jpg'<br>
and the file sample-image.jpg-thumb.png will have been created in the current directory.</blockquote>

<h2>Going over the example code</h2>

An exact walkthrough of the example code can be found in the <a href='ExampleCodeRundown.md'>ExampleCodeRundown</a>