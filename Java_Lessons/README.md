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
 - [Random](#random)
 - [Strings](#str)
 - [Dates](#date)
 - [Some Functions Examples](#function)
 - [Java Doc](#doc)
 - [Scanner](#scanner)
 - [Scope](#scope)
 - [Logic Operators](#logic)
 - [Bitwise Operators](#bit)
 - [Overload](#over)
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
    ~~~
    java [classname... it is the .class bytecode file however runs it classname only]
    ~~~
    - For more [peak the example](./MeuPrimeiroProJava/CMD.png)
> To run a java package: compile main class and then run subpackage1.subpackage2...main <br>
> It is not worth to run java project outside an IDE because it takes too long to run and iterate.


### Gradle
Another way to compile, build, distribute and automatizate the compiling/build easily is using **gradle** or **gradlew** foun [here](./../Gradle_Lessons/README.md)

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
 > It is highly recommended that you start a project and sets it up for your IDE... otherwise it will get buggy.
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

To use classes from others packages you will need to ***import***<br>
[Here](./CollectionsC/) is a nice example of how things works.

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
It can be a vector or a matrix of mult dimensions... It is created by pointer that saves inside it other pointer that saves... (so on, even tho Java dont have a direct pointer definition). <br>
To write an Array that have a presetted value:
~~~
type [] name = {i0, i1, i2, i3, i4}
~~~
To write an Array without value just:
~~~
type[] name = new type[numberInstance] ;
~~~
Or for multdimensional arrays:
~~~
type[][] name = new type[numberInstance][numberInstance2] ;
~~~

You cannot print an array directly (because it will show you its memory address - pointer) <br>
To print you will need to use a repetition loop or *for each* function <br>

### for each:

It is used as another way of using for: ***for(type name: array from that type){}***

### Atributes:

 - **.length**: will show you its length

<div id='collections' />

## Collections
Interface Collections has sub interfaces List, Set and Queue

<div id='lists' />

### Lists

To work with lists you will need to import ***java.util.List*** <br>
 - It has index, but to iterato you will need and Iterator Object;
 - Accepts duplicates
 - Can be of any other objects,
 - Comparable and comparator is important abstract methods...
 - The order you put it ther order it stays put;
 You can have two type of lists both dynamic types... Their diferences are listed [here](https://medium.com/@mckenziefiege/arrays-linked-lists-and-big-o-notation-486727b6259b)
 - LinkedArray
   - It is doubly linked.
   - Better for manipulation (adding or removing it)
   - They are static under the hood and linked one to another using pointers
   - O(1) to adding in beggining
   - O(n) to access or removing or creating in any location
 - ArrayList
   - It is better used when adding/removing is less common than accessing it.
   - Under the hood Java produces a static array... when you need to increase its size, you can
   - O(1) to access from any location or creating on the beggining
   - O(n) to create or remove in any location
You can Iterate it using an **Iterator**, using for each or using a for .get method <br>
Some methods:
 - .add()
 - .get()
 - .indexOf()
 - .size()
 - .remove()
 - .addAll()
For some examples, just give a peak at [CollectionsA](./CollectionsA/src/edu/exercises/list1/Main.java). In that example you will see some:
 - Lambda functions
 - Colectors
 - Iterator
 - List
 - Copy list to another
 - Create a list
 - remove an item
 - add an item
 - Sum
 - Average

<div id='set' />
>> When implementing Set and Map you need to have overrided equals method and hashcode methods. <br>
>> A sugestion is:
~~~
Objects.hash(element1,element2,...)
~~~
~~~
Objects.equals(this.atr,((Cast)obj).atr) && Objects.equals(this.atr2,((Cast)obj).atr2) ...
~~~
### SET :
To work with lists you will need to import ***java.util.Set*** <br>
You usually use SET to dump a list and remove its duplicates.
 - Do not has index
 - Do not accept duplicates
   - It checks *equals* and *hashcode* methods.
   >If two objects are equal according to the equals(Object) method, then calling the hashcode() method on each of the two objects must produce the same integer result.<br>
   > method equals and hashcode must see the same atributes, and, work them same way to be equals;<br>
   > On TreeSet though, it will remove duplicates based on comparable or comparator.
   - Some example [here](./CollectionsBa/src/edu/exercicios/try1/LinguagemFavorita.java)
   - More help: [1](https://dzone.com/articles/working-with-hashcode-and-equals-in-java), [2](https://www.youtube.com/watch?v=QvHBHuuddYk)

It has three types:
 - HashSet 
   - Internally it is converted to a HashMap..
   - Dont maintain any order because it depends on Hash function
   - Best Performance
   - null will be counted once...
 - LinkedHashSet
   - Internally it is converted to a LinkedHashMap..
   - Maintain insertion order
   - Its performance is better than TreeSet
   - null will be counted once...
 - TreeSet
   - Internally it is converted to a TreeMap..
   - It is has natural order of the default sort()/comparable()
   > TreeSet will discard duplicates based on comparable or comparator. Be cautious: it is diferent than HashSet and LinkedHashSet <br>
   > If you want to remove duplicates and order it, it is better arrayList to LinkedHashSet to arrayList

 ~~~
 Set<type> nameOfSet = new SetType<>()
 ~~~
To iterate and compare object you will need an iterator object
 - .contains(value) : retorna true ou false 
 - Collections.min(Set)
 - Collections.max(Set)

### Map:

That collection is linked with hashtable. They usually map a key to a value (just like a dictionary).<br>
There are three types of MAP:
 - HashMap
   - Big O (1) to access, save and remove
   - null key allowed
   - Random order - variant depending on hashcode.
   - methods *equals* and *hashCode* needs to be overriden
 - LinkedHashMap
   - Big O (1) to access, save and remove
   - Maintain the order in which it was put like a stack
   - methods *equals* and *hashCode* needs to be overriden
 - TreeMap
   - Big O (log(n)) to access, save and remove
   - Natural order from comparable or a order from a comparator.
   - methods *comparaTo* from Comparable interface or *compare* from comparator interface needs to be implemented.

Click [here](./CollectionsC) for an example!<br>
Some Functions:
 - .put(key,value)
 > *equals* and *hashcode* is used to remove duplicates in keys, otherwise they use pointer value
 - .remove(key)
 - .containsKey(key)
 - .get(key)
 - .clear()
 - .size()
 - .keySet() : returns HashSet of the keys
 - .values() : returns arrayList of the values
 - .entrySet() : returns a diferent way of visualizing it : \[key1=value1, key2=value2,...]

### Iterator:
Needs to import java.util.Iterator;
~~~
   Iterator<typeWhichIsGoingToBeIterated> iteratorName = collectionName.iterator();
   while(iteratorName.hasNext()){
         // iteratorName.next() gets iterated value
   }
~~~
You can use the iterated's methods.

### Comparator:
Used when things needs to be ordered. 
 - return 1 to get it to right
 - return -1 to get it to left
 - return 0 to maintain
You can encounter examples on exercises such [as](./CollectionsBa/src/edu/exercicios/try1/Main.java)

## Conversões automaticas de tipos de variaveis... Coersão

 - se voce colocar string somando um numero: o numero vai ser convertido para string e então concatenado

<div id='class' />


### Stream
Used to filter, iterate through a Collection... Usually requires lambda functions<br>
Some methods:
 - .foreach :  it is a foreach VOID
 - .mapToInt : it is a foreach returning int in each loop
 - .mapToDouble : it is a foreach returning double in each loop
 - .map : it is a foreach returning String in each loop
 - .sum()
 - .average()

## Class
Classes are objects blueprints. Objects are abstractions of a instance of a problem. <br>
To create a class simply:
~~~
[incapsulation mode: public/protected/private] class NameOfClass{
   //class atributes and methods
}
~~~
> It might be a good idea to ensure an YAGNI and SGR principles 
>> Usually a class will interact with OTHER classes... so it will need to import or to be in a package.

<div id='contructor' />

### Contructor

The constructor are a special method that are run to create a NEW OBJECT (an isolated instance of the blueprint). <br>
To create a constructor simply:
~~~
[incapsulation mode: public/protected/private] class NameOfClass{
   NameOfClass(){
      // Constructor things...
   }
}
~~~

<div id='contructor' />

### Destructor:

The destructor are a special methods that are run to help garbage colector to delete an existing OBJECT (an isolated instance of the blueprint). <br>
To create a destructor simply:
~~~
[incapsulation mode: public/protected/private] class NameOfClass{
   void finalize(){
      // destructor here
   }
}
~~~
> finalize() is a special word in java.

<div id='atribs' />

### Atributes and Parameters
   To create an atribute of an object simply:
> Atributes are objects/functions linked variables <br>
> Parameter are passed values for methods/functions

~~~
[incapsulationMode: public/protected/private] class NameOfClass{
   [incapsulationMode] [type] nameAtrib;
}
~~~
   To access it inside your object use ***this.nameAtrib***. You can use nameAtrib directly, however, it is not recomended because you might create a parameter with same name. 

<div id='met' />


### Methods

 Can have diferent modifiers: 
 > Its sign is its name plus its parameters <br>
 > Constructor creates an object <br>
 > A destructor destroys an object <br>
 > Message is when you execute it () symbol <br>
 > Parameters can be passed by **copy** or by **reference** <br>
 >> The *copy* is passed and so the outside variable is not effected <br>
 >> The *reference* type you pass its memory address and so the outside variable is affected  <br>
 > Use camelCase

 - ***public***, ***protected*** or ***private***
 - concrete or abstract
 - static or final
 > static is when a methods is linked to its class instead of its object instance
 - type expected to return or void
 - Its name
 - Parameters
 - Exceptions
 - Its code.

Set/Get methods are methods used to access atributes inside an object

<div id='obj' />

### Creating new Object:
First of all, your code needs to see the class through import or package. <br>
After that simply:
~~~
ClassName objName = new ClassName(); 
~~~
> You can call whanever overloaded constructor you want! (that are implemented of course). <br>
> The returned value is a *pointer* a *memory address*. To use it properly you will need to access its atributes or its methods! 
>> Be carefull when using: objA = objB ... You will be linking it pointer and so a change in one of them will mean a change in the other! Dont forget to create a ***new*** instance. <br>
>> objName.Method() for normal methods<br>
>> ClassName.Method() for *STATIC* methods
> You can have a list or an array of an object <br>

### Heritage:
Creating sub-classes: you can reuse code.

~~~
class subClassA extends superClassb{
   //implements class A
}
~~~
Class A heritages class B atributes and methods... Class A is specialized in relation to B <br>

You can have some types of heritages:
 - Simple: Sub class have just one Parent class
 - Multiple: Sub Class have more than one parent class
 > Multiple heritage is avoidable... Java doesnt implement.

To correctly implement a class that completes the superclass:
~~~
SuperClass objName = new SubClass()
~~~
This is named Upcast.

### Polimorfism
When same method acts diferently depending on subclass or atributes. Polimorfism can be performed using overriding, abstract and overloading. <br>
It is said to poliform when you create a list of SuperClass when each instance is a subclass... then, because each subclass has an @override method, its methods acts diferent from others. <br>
If you call a method of a subclass it will be called as pure override... In other words, polimorfism is just a concept. <br>

### Interface and abstract:
An interface is a class that only has abstract methods... It is used when you want to use functions predefined, however, implement its methods in diferent ways... It is almost a superclass, or, an abstract class.

### Extends:
Another way to create a subclass heritaging all methods and atributes.
~~~
class subclass extends superclass{
   
}
~~~

<div id='random' />

## Exception:
Makes code robust and reliable. <br>
Exceptions interrupts normal code flux. <br>
They are subclasses of *Throwable* which is subclass of Object. <br>
There are three types of **problems**:
 - **ERROR** : cant be treated and will break your code.
 > Indicates problems with JVM resources.
 - **Unchecked (Runtime Exception)** :  can be avoided if treated. Even if you dont treat it, wont break your code. Are subclasses from RunTimeException Class
 > Compiler cant predict it. Usually is created by logic error. JVM cant predict it
 - **Checked Exception (Exception)** : can be avoided if treated. If you dont show Java Compiler the trhows of CheckedException, then it wont proceed with compilation. If you Throws the Checked Exceptions it will run, BUT, it can break yout code if the exception happens. To avoid breaking your code, treat it with try/catch/finally .

 How to treat Exception:
 ~~~
 try {
   //codes that might trigger an Exception
   }
 catch (ExceptionType e){
   // Your IDE might help you out on ExceptionType
 }
 // You can have more than one.. The especialized Catch must be lexically above the generic one
 finally{
   // Optional ... Always run.
 }
 ~~~
 >You can create try/finally only
 - .printStackTrace(); //prints stack trace

Throws is a method for throwing one or more Exception. Throw is one Exception especifically <br>
You use Throws when you desire to treat a checked exception later on. <br>
You can create your own exception by extending Exception Class <br>
Exception Types:
 - NumberFormatException
 > Cannot parse from string to number
 - ArithmeticExeption
 > Because division by zero.
 - FileNotFoundException -  Checked Exception
 > File wasnt found.. Subclass of IOException
 - IOException - Checked Exceptions
 - ArrayIndexOutOfBoundException 
 > You tried to access a memory space that wasnt allocated by JVM
It is possible to Customize an Exception by extending Exception Class. <br>
However JVM wont catch it. you will need to call a generic type and then specialize by creating a new instance of that customized...
~~~
throw new CustomizedException(argsYouVeCreated);
~~~
IF you create an instance of a CustomizedExecption, then, you can catch it later on!.

## Random

To create an randomizer object:
Import its package:
~~~
import java.util.Random; 
~~~
~~~
Random name = new Random();
~~~
To generate a randomized using *name* object:
~~~
type otherName = name.nextType(bound)
~~~

<div id='str' />

## Strings

 - ***.concat(str)*** : to contat a base string to another
 - ***Just use the "+" sign***: to concat two strings
 - ***.equals()***: to compare Strings value
 - ***.equalsIgnoreCase()***: to compare strings ignoring uppercase letter

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
It is an object that can receive information from input terminal.<br>
First, import its package;
~~~
import java.util.Scanner;
~~~

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

<div id='over' />

## Overload:

Its is the capability of using same method/function name whanever changing the parameter types and expected return. <br>
A valid Overload is a diferent Method/Function signment (name plus parameters type order)... <br>
It can have diferents parameters and its receiving orders;
> Overload is diferent concept of overwrite. <br>
> You can overload if return is diferent type, diferent order type on parameters, diferent parameters.


<div id='link_u' />

## Usefull Links:

 - [Basic Java](https://glysns.gitbook.io/java-basico/)

<div id='link_o' />

## Others Links:
 - [Teacher GitHub Material](https://github.com/digitalinnovationone/trilha-java-basico)

## Generating IDs:
[UUID class](https://www.youtube.com/watch?v=lGh1PbIY_Sc) creates it using 128 bits or 15 bytes
> Curiosity you can save it in [mysql](https://www.mysqltutorial.org/mysql-uuid/#:~:text=In%20MySQL%2C%20you%20can%20store,IS_UUID) using Binary(16) <br>
> [Is it really unique?](https://towardsdatascience.com/are-uuids-really-unique-57eb80fc2a87)
>> Nope, but there is chance of 99,99% of being unique.


## Tests

It is important to test things to guarantee it is working properly, and, to guarantee your code accomplishts costumer requirements and/or expectations (that usually differs). <br>
It is a good way to understand a code running a test! Because there, it will show the clauses that MUST work/or not. <br>
Tests **DO NOT ENSURE** that your code is free of BUG <br>
There are plugins in [Gradle](./../Gradle_Lessons/README.md) used to test it out!<br>
In Java you can run it using tag (javadoc) @Test just above method and you  will use ***Assertions*** class. It is valid to mention that you will create another class just to test it. 
The motive in which you always re-run all the tests is to ensure the new feature are not affecting others modules! <br>
The more you test: better is your code metric! <br>
Types of tests:
 - Unity Test
 - Performance test

These can be:
 - Automatizated or not!
It is important that a test "**always**" work <br>
Automatize your test... Gradle automatize them for you. <br>
Create coverage tests for classes interactions!! <br>


### JUnit
Composed by packages:
 - JUnit Platform :  its engine
 - Junit Jupiter: where most of classes are. The **most used**
 - Junit Vintage : more tools
You can use it: installing manually, using Maven or using Gradle <br>

#### Configurating Junit:
 1. Create a new Gradle environment and set Junit up Jupiter
 2. Open build.Gradle and put Jupiter engine getting it [here](https://mvnrepository.com/)
   1. junit
   2. junit engine jupiter
   3. select gradle config
   4. copy and paste in buil.gradle dependencies (check if mavenCentral() was put in repositories)
> Usually it will be made automatically by Gradle...
~~~
repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.1'

    // This dependency is used by the application.
    implementation 'com.google.guava:guava:31.1-jre'
}
~~~

### Unity Tests
It is called that way because you test the smaller code module possible: such function or class. <br>
You might write unity test while developing: together, later or before developing (TDD) <br>
Unity Test is the cheapest of them all! <br>
Here are some methods for this class:
 - .assertTrue()
 - .assertFalse()
 - .assertEquals()
 - .assertNotEquals()
 - .assertArrayEquals()
> They need to have same length <br>
> They need to have same order
 - .assertArrayNotEquals()
> Same as before
 - .assertNull()
 - .assertNotNull()
 - .assertThrows()
 - .assertDoesNotThrows()

> Be CAUTIOUS... **gradle run tasks by default: do not check gradle test**
To create that task in build.gradle:
~~~
tasks.named('run'){
   dependsOn 'test'
}
~~~
OR
~~~
// Another way to do the same without changing 'run' task
task testAndRun{
    group "myTasks" 
    description "Check the tests first, run later"
    dependsOn "test"
    finalizedBy "run"
}
~~~
To validate test in VSCODE you should have installed the Gradle extension, Java Extension and the Test files.java needs to have the right name (otherwise it will error).

#### BEFORE AND AFTER:
There might be test that needs to do some activities before starting the tests... and after the tests... In this case you use @BeforeAll @AfterAll above the method... They will work for all methods in the class . It will be run once<br>
You can also use @BeforeEach and @AfterEach to a single test method in that class. It will be run for EACH test method <br>

#### ASSUMPTIONS
From Class Assumption <br>
It does not break your test if failed.. It just continue (by-passing it). <br>
Used to manipulate test flux:
 - .assumeTrue()
 - .assumeFalse()

#### Conditional:
Used to check using @ and work just like assumption. <br>
Must be put between @test and method. <br>
Examples of @:
 - @EnableOnOS(OS.LINUX/OS.MAC/OS.WINDOWS)
 - @EnableOnJRE(JAVA_17/...)

#### Testing Exceptions:
Used to validate that your *"new throw Exception("blabla")"* is working properly without breaking your test chain. <br>
~~~
Assertions.assertThrows(ExceptionType.class, ()-> //function that should except)
~~~

#### Ordering Tests:
Just above the test class, use:
~~~
@TestMethodOrder(a method Orderer)
~~~
 - ***MethodOrderer.OrderAnnotation.class*** : in this case it will run using @Order(1...) above each method
 - ***MethodOrderer.MethodName.class*** : will choose A...Z order in method name
 - ***MethodOrderer.Random.class*** : random order
 - ***MethodOrderer.DisplayName.class*** : in this case it will run using A...Z of displayed name @DisplayName("Funcionalidade A sendo avaliada")

### What needs to be tested?
DO NOT WRTE tests in java app development <br>
Do NOT forget to @Test <br>
 - Limit values cases
 - True and False cases
 - Ordering
 - Equallity
 - Nullibility
 - Exceptions (try/catch)

*******
[Wanna return to the begin?](#summary)
*******