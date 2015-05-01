# Introduction #
These are the annotation processor options supported by the @ProviderFor annotation processor. They are not recommended for normal use but are mainly intended for debugging purposes. They can be accessed by passing the -A{option}[={value}] option in the javac command call.

The options supported are spi\_dir, spi\_disabled, spi\_log and spi\_verbose

# Directory #
## spi\_dir ##
Use this option if you want to have the provider-configuration file to be written to directory that is not the standard compiler output directory. The provider configuration file will be written to <provided value>/META-INF/services/. This defaults to the standard compiler output root directory.

N.B. the <provided value> must be in the form {foldername1}[/{foldername2}] etc. and will be interpreted as a subfolder of the output directory you provided to javac using the -d flag or the default output directory.

# Boolean options #
These options can be supplied without a value to set them to true. Alternatively you can provide either false or true as value to set them to one of those options. They all default to false.

## spi\_disabled ##
Via this option it is possible to disable the processing of the @ProviderFor annotation. Other annotations will still be processed normally.

## spi\_log ##
This option turns on extended logging to a log file. Both errors and process updates are logged in a log file located in the same place the provider-configuration file is created.

## spi\_verbose ##
This option turns on a more verbose form of messaging to the console and of logging to the log file.

// TODO Add examples