# Introduction #
This page explains how to get the example source code to your machine, for an analysis of the code you are referred to [ExampleCode](ExampleCode.md)

# Installing the example code #

To get the example code on your machine, you can either download and unzip the example code from this site, or do a svn checkout of the example project.

## Download Example Archive ##
You can get the example source code as one simple archive here: [thumbnails-src.zip](http://spi.googlecode.com/files/thumbnails-src.zip)

After you have unpacked, the thumbnails directory contains an ant build file that you can use to easily compile and package the code to test it.

## Checkout Example Project Using Eclipse ##
  * In Eclipse, open the SVN Repository Exploring perspective
  * In the SVN Repositories view, create a new repository location
    * In the URL field, enter http://spi.googlecode.com/svn
    * Press Finish to add the location. The location will be verified by Eclipse
  * From the repository, open the trunk node
  * From the trunk node, open the examples node
  * Select all subnodes from the examples node
  * Open the context menu and select checkout. This will get the source to your workspace.
  * In the Package Explorer (Java Perspective) you should now have three new projects.

## Checkout Example Project Using SVN ##

To checkout the example project from the svn repository, follow the instructions on [the source page](http://code.google.com/p/spi/source/checkout) to connect to the svn repository. However, instead of the provided URL, you should check out the following projects:
  * http://spi.googlecode.com/svn/trunk/examples/img-thumbnailer
  * http://spi.googlecode.com/svn/trunk/examples/thumbnails
  * http://spi.googlecode.com/svn/trunk/examples/tools

The thumbnails project contains an ant build file which (if you placed all three projects in the same directory) you can use to easily compile and package the source code to test it.