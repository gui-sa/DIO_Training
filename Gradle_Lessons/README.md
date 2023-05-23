# Gradle

GROOVY is a java like language... It works using it. <br>
It automates the building and compilation process <br>
Creates a .jar or .apk <br>
Android Studio comes with it installed by default. <br>
It does dependency management: 
 - Version Controll
 - Downloads packages
 - Sets it up
 - Diferent versions managements
 - You can manage flux to test it first and just when passed: generate the .jar or .ppk
It generates reports - Javadoc <br>
You can install plugins to it <br>

Whats is GRADLEW ? It is Gradle Wrapper... So, you can use gradle environment without installing gradle directly. <br>
So, it is guaranteded that an environment is the same in each machine. <br>

## Installing using gradlew
 1. Simulating as if gradlew was already setted up
   - [Clone it](https://github.com/bmartho/GradleCourse)
   - Go to aula 1.
   - Open bash
~~~
./gradlew
~~~
 > when using that specific gradlew, just use command above + extra tasks
~~~
./gradlew -version
~~~
To show all tasks:
~~~
./gradlew tasks
~~~
An example of a task:
~~~
./gradlew run
~~~
>It will compile and run to you! withou an IDE

## Installing Gradle
 - Download from oficial web site
 - Unzip
 - Advanced System Settings -> Click on Environment Variables 
 - Edit PATH
 - NEW
 - Puts entire path to */bin* folder 
Test it out:
~~~
gradle -version
~~~

## Commands
The *tasks* depends on the directory your project is... because of ***build.gradle***

To download dependencies:
 1. repositories : where it will be downloaded
 2. path
 3. version

Some ***repositories***:
 - jcenter()

Some ***dependencies***:
 - implementation ("com.google.guava:guava:30.1-jre") 
 >Found on guava documentation

## BuildScript:
It is the file ***build.gradle*** wrote in [Groovy](https://groovy-lang.org/) or Kotlin

### Plugins:
The add more tasks... They are like includes. <br>
Some plugins:
 - "application"
 > run, build... it already contains "java" and "distribution"
 - "Java"
 - "distribution"
~~~
plugins {
    id 'application'
}
~~~
After that you will need to create the name of plugin to configure that...

### application:
It is the default plugin... to configure that:
~~~
application {
    mainClass = 'Project.App'
    applicationName = "NomeDaMinhaAplicacao"
    executableDir = "testingFolder"
}
~~~
> mainClass is the class that will **run** <br>
> applicationName will rename our project <br>
> executableDir = the name of the folder in which the executable will stays... inside folder "build"

### Starting a new Gradle Configuration
Simply run:
~~~
gradle init
~~~
And choose things.... <br>
That is probably why things got strange when I tried to use Kotlin... Because the choosen was groovy <br>
When finished it will create a gradlew

## Multi-Modules or multi-projects
You want to separate modules because it is easier to maintain, and because each component might be separated than the others. <br>
In this case you need to configure ***settings.gradle*** <br>
**includes** are modules there... with the name of folders in main folder <br>
Other diferent things is the dependencies... (implementation)

## Customizing TASKS
To create a task (GROOVY when tested):
~~~
task(group: "myGroup", description: "Customized Task", ){
  doFirst{
    //Something
  }
  doLast{
    //Something
  }
}
~~~
To create configurations: <br>
You can use it once in each task
 - ***dependsOn*** : to execute a task before it.
 > You can use more than one using '[]'
 - ***finalizedBy*** : Runs it when everything inside it is finished
 - ***mustRunAfter*** : It can be executed without it.. BUT, if you execute it, it MUST be AFTER
 > You can execute more than one task at time!


## TASK TYPES:
Normal tasks... whenever with an extra atribute "type:" <br>
types:
 - Delete
 > Will enable **delete** function
 - Copy
 > Will enable **from**; **into** 
 - Zip
 > Will enable **baseName**; **destinationDir**; **from**

# Curiosities:
You can install others external packages.. Such example:
 - Google Guava jar : Google Java packages.. Inside it there are packages such File package
When using KOTLIN with Gradle, some syntax changes! 