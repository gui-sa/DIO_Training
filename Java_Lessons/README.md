# JAVA_LESSONS

<div id='summary' /> 

*******
Sumary:

 - [Introductions](#intro)
 - [Setting Up Java](#set_up_java)
 - [Class Anatomy](#class_anatomy)
 - [Folder Structure](#folder_structure)
 - [Variable Types](#types)
 - [Automatic Conversions](#coerce)
 - [Strings](#str)
 - [Dates](#date)
 - [Some Functions Examples](#function)
 - [Java Doc](#doc)
 - [Scanner](#scanner)
 - [Scope](#scope)
 - [Logic Operators](#logic)
 - [Bitwise Operators](#bit)
 - [Usefull Links](#link_u)
 - [Other Links](#link_o)

*******



<div id='intro' /> 

## Introductions:

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

<div id='set_up_java' /> 

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

<div id='class_anatomy' /> 

## Class Anatomy:

 - Every Class name starts UPPERCASE and the others words same way. Example: "JavaEhLegal"
 - *main* methods should start (inside a public class): * public static void main(String [] args){}*
 - Classe principal do arquivo deve ter o mesmo nome do arquivo.java
 - Variaveis escrita em camelCase 
 - Variaveis todas em maiusculas sao assumidas como **final** e são constantes e imutaveis
> final String BR = "Brasil"; <br>
> Em caso de Palavras grandes final, usamos o _ para separar, exemplo: "final String MANGA_VERDE"
 - Normal variables can be reassigned
 
<div id='folder_structure' /> 

## Folders Structure

The basic Structure of a java project:
 
 - ***bin***: Created by IDE to put *.class* files
 - ***lib***: Created by the IDE to organize its libraries
 - ***src***: Where the source code and bytecode lives


Inside ***src*** folder, create ***a*** new folder for each level of class:
 - Commercial as ***com***
 - Organizational as ***org***
 - Educational as ***edu***

Exemple: If your company is named *enterprise*<br>
So the package the notification package will be named as ***com.enterprise.notification*** <br>
It can grow for example:  ***com.enterprise.notification.whatsappapi*** <br>
In this case there will be /src/com/enterprise/notification/whasappapi/api.java <br>

In your code.java (this case: api.java) you need to write in the first line:
~~~
package com.enterprise.notification.whasappapi;
~~~

Might have more than one file inside a package

<div id='types' />

## Variable types (type name = value):

Linguagem fortemente tipada. <br>
Esses são os tipos primitivos (não sao objetos): 
> Todas variaveis primitivas são armazenadas na memoria STACK e possuem endereço-valor.

 - **byte:** 1 byte
 - **short:** 2 bytes
 - **int:** 4 bytes
 - **long:** 8 bytes
 > Se for long a variavel tem que terminar com um **L** no final: <br>
 > long teste = 1234L
 - **float:** 4 bytes
 > Se for float a variavel tem que terminar com um **F** no final: <br>
 > float teste = 1.23F
 - **double:** 8 bytes
 - **char:** 1 byte
 - **boolean:** (true/false) : 1 byte

Geralmente usamos int e double por garantia de funcionamento e facilidade de conversão... Lembre-se que memoria fisica é "barata" e vale a paz e confiabilidade do algoritmo. <br>
Converter um numero valor pequeno em um grande: não vai ter errado, mas o errado o compilador vai reclamar.
> Voce pode usar o **cast** o (type)var, porém, lembre-se que é arriscado e que voce pode perder informação no processo.

<div id='array' /> 

## Arrays:

Its an object that saves sequentially a same primmitive type <br>
It is **STATIC** <br>
It can be a vector or a matrix of mult dimensions... It is created by pointer that saves inside it other pointer that saves... (so on, even tho Java dont have a direct pointer definition). 


<div id='coerce' />

## Conversões automaticas de tipos de variaveis... Coersão

 - se voce colocar string somando um numero: o numero vai ser convertido para string e então concatenado

<div id='str' />

## Strings

 - .concat(str)
 - Just use the "+" sign

<div id='date' />

## Date:

To create a new object Date use **new**:
> Date datat = new Date()

<div id='function' />

## Some Functions example:

 - System.out.print() to print something

<div id='doc' />

## Java Doc:

Estudar a documentação é chave. [Clique aqui](https://docs.oracle.com/javase/8/docs/) para acessar.<br>
Enquanto escreve uma classe, voce pode adicionar etiquetas (tags):<br>
Voce pode usar uma tag *@tag* dentro de um comentario /**  */ <br>
A função javadoc atualiza e cria uma documentação de todas as classes (que foram escritas) para ti.

<div id='scanner' />

## Scanner 
It is an object that can receive information from input terminal.

~~~
Scanner nomeDoScan = new Scanner(System.in).useLocale(Locale.US);
~~~

Then you can choose the primitive type to be converted or awaited:
~~~
String nomePessoal = nomeDoScan.next()
~~~
~~~
int idade = nomeDoScan.nextInt()
~~~
~~~
double altura = nomeDoScan.nextDouble()
~~~
<div id='scope' />

## Scopes:
Os escopos são feitos por meio dos blocos.

<div id='logic' />

## Logic Operators:
 - &&
 - ||
 - !
 - ^

<div id='bit' />

## BitWise Operations:

 Dont mix them up with Logic Operators. <br>
 To Write a binary number just use *byte* type and in the value "0b\[binVal]"
 - & 
 - |
 - ~
 - \>>
 - \>>>
 - <<

<div id='links_u' />

## Usefull Links:

 - [Basic Java](https://glysns.gitbook.io/java-basico/)

<div id='links_o' />

## Others Links:
 - [Teacher GitHub Material](https://github.com/digitalinnovationone/trilha-java-basico)

*******
Sumary:
 - [Summary](#summary)
 - [Introductions](#intro)
 - [Setting Up Java](#set_up_java)
 - [Class Anatomy](#class_anatomy)
 - [Folder Structure](#folder_structure)
 - [Variable Types](#types)
 - [Automatic Conversions](#coerce)
 - [Strings](#str)
 - [Dates](#date)
 - [Some Functions Examples](#function)
 - [Java Doc](#doc)
 - [Scanner](#scanner)
 - [Scope](#scope)
 - [Logic Operators](#logic)
 - [Bitwise Operators](#bit)
 - [Usefull Links](#link_u)
 - [Other Links](#link_o)

*******