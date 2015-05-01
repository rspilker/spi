# Introduction #
The @ProviderFor annotation is an annotation meant for easing the implementation of and increasing the code robustness of code that works via the [SPI](GeneralSPI.md) principle.

To use the annotation the latest version of this jar should be downloaded and used as an annotation processor during compilation.

# Usage #
Before using the @ProviderFor annotation make sure you are using compatible software, as described in [Prerequisites](Prerequisites.md)

## Getting the Annotation ##
You can get the annotation and its processor from the project home page, the downloads page or directly via this link: [spi-0.2.1.jar](http://spi.googlecode.com/files/spi-0.2.1.jar)<br>
Alternatively it is possible to use the archive which includes the source, which can be downloaded here: <a href='http://spi.googlecode.com/files/spi-full-0.2.1.jar'>spi-full-0.2.1.jar</a>

If you are only interested in the source code of the project, you can get it here: <a href='http://spi.googlecode.com/files/spi-src-0.2.1.zip'>spi-src-0.2.1.zip</a>

<h2>Creating an SPI set up using the Annotation</h2>
How to create the entire SPI infrastructure is explained here: <a href='HowToSpi.md'>HowToSpi</a>

<h2>Using the Annotation Processor</h2>
<h3>Eclipse</h3>
After the jar has been added to the classpath, it is required to set the project settings so that it uses the jar as an annotation processor.<br>
<br>
How this is done is explained in more details here: <a href='EclipseSettings.md'>EclipseSettings</a>
<h3>Command Line</h3>
Since our annotation processor is a service provider for the javax.annotation.processing.Processor SPI it should be enough to have the jar included in the classpath of the project you are trying to build. Just make sure you have not turned off annotation processing and have not circumvented the normal annotation processor discovery process. Also note that this annotation processor is designed for use with Java 6.<br>
<br>
<h2>Annotation Processor Options</h2>
The annotation processor supports several different processor options which are mainly used for debugging. Most of these are not for recommended use but what they do is described here: <a href='ProcessorOptions.md'>ProcessorOptions</a>