# Java #
The @ProviderFor annotation can be used with JDK1.6. The reason we don't support Java 5 is that the Annotation Processor API has significantly changed.

If you run javac, the jar just needs to be on the classpath to do it's work.

# IDE #
We have tested on Eclipse. However, NetBeans should not be a problem, since it uses javac under the hood.

We have no idea about IDEA support yet. It might work. Then again, it might not.

# Platform #
Everything works great under both Windows and Linux. It should also work fine on the Mac.

N.B. Currently, due to a [bug in javac](http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6647996) under Linux, you should specify the -d option for the output folder to gain the most benefit. If you omit this parameter, all service files will be generated in current folder. If you happen to have a problem with this bug, please use your (free to obtain) sun account to vote for this bug.