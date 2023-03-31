# Common gradle build script wrapped up into gradle plugins 
Project encapsulating common gradle build scripts to bootstrap application quickly

## Kotlin
Example usage of the kotlin plugin 
```
plugins {
    id("com.codebootup.kotlin") version "1.0.0"
}
```
Version 1.0.0 setup a Kotlin build script with JDK 17.  It also pulls in kotlin test dependencies as no kotlin code should ever be written without tests included.

