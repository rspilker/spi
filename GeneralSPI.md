# Service Provider Interfaces #

A Service Provider Interface is a code construct to create easily extensible libraries. The _service_ is the set of interfaces and/or abstract classes that combine together to perform a specific function. The _service provider_ is a specific implementation of those interfaces.

## Advantages ##
The major function and thus the main advantage of using an SPI is the fact that it can be extended without adjusting the original programming. This allows people to write their own implementations of the service you provide.

All that is required is for them to include the service provider in the class path of the program and it will use the extensions they have written automatically.

## Creating a service in Java ##

It is possible to use the [ClassLoader#getResources(String)](http://java.sun.com/javase/6/docs/api/java/lang/ClassLoader.html#getResources(java.lang.String)) to build a service provider but the easiest and most commonly used way is to use the [java.util.ServiceLoader](http://java.sun.com/javase/6/docs/api/java/util/ServiceLoader.html) class.

For this class to find all implementations of a service every jar containing service providers must include a _provider-configuration file_ META-INF/services/<!SPI-fully-qualified-binary-name> which lists the fully qualified binary names of all service providers included in that jar.

For a more detailed explanation of how to create a Service Provider Interface architecture please read [HowToSpi](HowToSpi.md)

## Common Pitfalls of SPI's in Java ##
This chapter is also known as: Why do you want to use the @ProviderFor annotation

Since the actual implementation of SPI functionality in Java is quite a mystery, there are quite a bit of pitfalls that could easily ruin a program. The most annoying feature of most of these errors is that most of them do compile properly and some even run, but the program will simply not work as it is supposed to work. This results that it can be very hard to track down bugs.

  1. The first pitfall is the fact that the whole system depends on files with the fully qualified binary name of the service provider interface as a name and which list the fully qualified binary names of all service providers. A small typo or other kind of problem with any of these names can interfere with the program.
  1. The ServiceLoader needs to instantiate the service providers to load them. It is therefore required that every service provider has a public no arguments constructor. If this is not the case the program will fail at runtime.
  1. Even if the provider-configuration file is set up correctly there is nothing that forces the programmer to actually implement the service provider interface in its providers. If through any kind of oversight this is omitted the program will still compile, but runtime things will mess up.

Since the provider-configuration file is generated automatically if the @ProviderFor annotation is used it eliminates the possibilities of mistakes in that area. Most other possible pitfalls are checked during compile time if the @ProviderFor annotation is used, this provides the provrammer with relatively easily trackable compile time errors.