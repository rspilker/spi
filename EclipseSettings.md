# Project settings #
  * First add the jar file to your classpath.
    * In this example we have created a project "tools" and added the file "mangosdk-spi-0.2.1.jar" to that project.
    * We have added the "tools" project to classpath of the implementing projects
  * Open the project Properties dialog
  * Navigate to "Java Compiler/Annotation Processing"
  * Check the "Enable Project specific settings" checkbox

> ![http://spi.googlecode.com/svn/trunk/wiki-images/eclipse-project-settings1.png](http://spi.googlecode.com/svn/trunk/wiki-images/eclipse-project-settings1.png)

> _Screenshot of the Properties window after enabling annotation processing for this project_

  * Navigate to "Java Compiler/Annotation Processing/Factory Path"
  * Check the "Enable Project specific settings" checkbox
  * Press "Add Jar..." or "Add External Jar..." to choose the jar file.
  * After this, the Properties window should look like this:

> ![http://spi.googlecode.com/svn/trunk/wiki-images/eclipse-project-settings2.png](http://spi.googlecode.com/svn/trunk/wiki-images/eclipse-project-settings2.png)

> _Screenshot of the Properties window after registering the jar file as an annotation processor_

  * Press OK to confirm
  * Eclipse will ask if it should rebuild the project. You probably want to.