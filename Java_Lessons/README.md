# JAVA_LESSONS
    Java is owned by Oracle. 
 - Java is made to run in any hardware and software (if supported)
 - Java **JDK** : Development Tools... There are various versions. To change from one to another you will neeed to reconfigure System Variables.
    - Inside JDK There are the **Compiler**: *javac*
    - *javac* generates the *.class*... This file is the **Bytecode**
 - Java **JRE** : Needed Plugin that the clients needs to have to run your aplication.... 
    - Inside JRE there are **JVM**: Java Virtual Machine
    - The JVM runs the *Bytecode*.
 - Your code in Java is Compiled to *Bytecode* that independent from javas platforms
 - The *Bytecode* is then **interepreted** using the *JVM* and translated to you OS System Calls.
 - WORA: Write Once Run Anywhere
 - POO Language: interelly written using objects and classes
    - Polymorphism
    - Encapsulation
    - Herigetage
    - Abstraction
 - Light: used in some embeeded systems.
 - Multhreaded
 - Automatic Garbage Colector
 - Strong Memory Management
 - Java Platforms are "Javas Development Environment" for diferent usages:
    - Java SE: *Standart Edition*, terminal aplications and basic grapphics functions
    - Java EE: "Enterprise Edition", WEB and corporative functions
    - Java ME: "Micro Edition", embeeded systems functions
    - Java FX: Used to create *Fancy eXperiences* sounds and graphics applications

## Setting JAVA UP
 - Choose an IDE
 - Learn all shortcuts/snippets to ampliate your eficiency
 1. Install JDK JRE: Install the right version... Always indicates it.
 > Search "java JDK \[version]"<br>
 > Login into oracle <br>
 > Install it without changing suggested root directory <br>
 >> Usually on Windows it is in C://Arquivos de Programas/Java <br>

 2. [Configurate Environment Variables](https://www.youtube.com/watch?v=-O4QVijnA7Y)
 > Need to SetUp Environment Varibles: JAVA_HOME and PATH

 3. Validate Java Instalation:
    - The JDV:
    ~~~
    java -version
    ~~~
    - The Compiler:
    ~~~
    javac -version
    ~~~

 4. Integrate VSCODE to Java by installing "Extension Pack for Java"
    - If you wish to run a Java project using Terminal, first use:
    ~~~
    javac [source_code.java]
    ~~~
    - This will create a *\[classname].class* file... Then, run:
    ~~~
    java -cp [directory] [classname... it is the .class bytecode file however runs it classname only]
    ~~~
    - For more [peak the example](./MeuPrimeiroProJava/CMD.png)

## Class Anatomy:
 - Every Class name starts UPPERCASE and the others words same way. Example: "JavaEhLegal"
 - *main* methods should start (inside a public class): * public static void main(String [] args){}*


## Some Functions example:
 - System.out.print() to print something

## Usefull Links:

 - [Basic Java](https://glysns.gitbook.io/java-basico/)