# Plugin as Groovy Project

The main idea is to turn a plugin from a bunch of .groovy files into something
resembling groovy/java projects.

## Classes

Plugin's code is stored in Groovy classes in project's properties (as before).
The difference is in the loading way: before we just took multiple sources and
glued them together, now they are copied to filesystem and path to the sources
folder is provided to the next step. This allows us to store our sources in 
the IDE-friendly way (and more important, allows us to run unit tests too).

## .jar Dependencies

.jar dependencies must be stored as simple .jars (not as grapes, like now),
and just copied to the same classpath.


## Demo
For now project contains a sample job, which runs using -cp flag and a simple unit
test, referencing a class from the plugin.

To run the job: run 'Sample Procedure' from the plugin (providing any values
as the parameters, they are not important).

To run unit test: 

    cd unit
    gradle test
