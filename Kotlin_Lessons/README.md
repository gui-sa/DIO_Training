# KOTLIN_LESSONS
 It can choose type for you, however one time assigned, cannot be changed;. <br>
 Uses same types as Java <br>
 Dont need ; to separate expressions (if it is on diferent lines) <br>
 Usually you will need an IDE... The main one is **ANDROID STUDIO**, however, it also comes installed with **intellij**. <br>
 It is Multiplatform an so can be used to Server-side, Android, iOS, Desktop, Web. <br>
- Segurança de nulibilidade 

## Basic Syntax:

 - ***fun*** for funtions
 > If it returns something you should say: <br>
 > fun (atr:type,atr2:type2):type {} <br>
 > if it is void, you dont need to put. <br>
 >> If you want to return something in line you can use: <br>
 >> fun (atr:type,atr2:type2)=something_to_Return
 > Prefix value or default value: <br>
 > fun (atr:type = something ,atr2:type2):type {}
 >> In this case atr is something by default.

 - ***val*** for read-only variables from **val**ue.
 > When no initial value is given, it is necessary to indicates its type <br>
 > val c : Int <br>
 > it is a good costume to use val (wisely). Use it like const in js.
 - ***var*** for variables from **var**iables.
 - ***vararg*** you can use one or more arguments... like an array of the same type.
 > when using vararg, to call others args you will need to call them like: <br>
 > atr = something <br>
 > it in a function call. It is valid even if you dont have vararg, but for reasons want to call them by any order.
 >> If a function receive a vararg and for some reasons want to pass it to another function as vararg instead of array it can use *varargName. That is spread operator.

 ## types:
  - Int
  - String
  - Long
  - Any
  - Char

 ## for:
 ~~~
 for (x in list ){
        //do something
 }
 ~~~
 
 ## if:
 ~~~
 if (condition){

 }else{

 }
 ~~~
 > You can use range Operators to check if something is **in** a range <br>
 > You can create a function IF in one line using: <br>
 > fun functionName(atr1,atr2) = if(condition) a else b
 >> In this case if condition is met, then 'a' is returned, else, 'b' is returned <br>
 > Ternary IF do not exist here

 ## Nullable Operator:
 Non initiallized variables arent treat as null. They simply break your code . <br>
 If you declare a variable like:
 ~~~
 var teste : String;
 ~~~
 That variable DO NOT ACCEPT null as a possibility.<br>
 to make it accept null you need to
 ~~~
 var teste : String?;
 ~~~
 > it is the "?" next to type
Same way, a function usually dont accept null. <br>
To treat null possibilities you will need use "?:" operator:
~~~
variable ?: inCaseItIsNull
~~~
Example:
~~~
fun teste( maybeString : String? = null ): String{
    if ((maybeString != null)&&(maybeString.length > 0)){
        return "yeaaah";
    }else{
        return "NOOO"
    }
}

fun main() {
    println(teste(""))
    println(teste(null))
    println(teste())
	println(teste("ok"))
    
}
~~~
## Strings:
Can be evaluated using .length atribute

## Class:
To create a class simply *class* . <br>
You dont need to implement equals, hashcode and comparable for every case.. <br>
To create a new instance (object) of a class simply:
~~~
val testeObj = className()
~~~
> You usually create an object using val... 
Classes are final by defalut in Kotlin which means it cannot be extended.<br>
To open a class simply:
~~~
open class ClassName(constructor){

}
~~~
>To create the same effect as "overload" in Java you can use default atributes
The same thing must be done to methods inside it: <br>
~~~
open fun functionName(){

}
~~~
To extend an open class:
~~~
class SubClass(constructoSubClass) : SuperClass(constructorSUPER){

}
~~~
To upcast : 
~~~
val varName: SuperClass = SubClass()
~~~
Here is an example of a class dealing with Set method, constructor and super:
~~~
abstract class Animal(val nome:String , var regiao:String = "Global", var populacao:Long? = null){
    abstract fun tentarSerFofo()
    override fun toString(): String {
        if(populacao!=null){
            return "${this.nome} from ${this.regiao} with an estimated ${populacao} individuals"
        } else {
            return "${this.nome} from ${this.regiao} with no estimation of the population" 
        }
    } 
}

open class Cachorro(var subEspecie:String, var reg:String="Global", var pop:Long? = null) : Animal(nome="Cachorro", regiao=reg, populacao=pop){
    override fun tentarSerFofo(){
        println("WOOF WOOF!!")
    }
   	override open fun hashCode() = this.subEspecie.hashCode()
    
    override open fun equals(other: Any?):Boolean {
    	if(other == null){
        	return false
        }
        if(other !is Cachorro){
            return false
        }
        return this.subEspecie == other.subEspecie
    }
    
    override open fun toString(): String {
        if(populacao!=null){
            return "${this.subEspecie} is a dog from ${this.regiao} with an estimated ${populacao} individuals"
        } else {
            return "${this.subEspecie} is a dog from ${this.regiao} with no estimation of the population" 
        }
    } 
}


class Pet (var nomePet:String, var esp:String, var local:String="Global"): Cachorro(subEspecie = esp, reg=local){
   	override fun hashCode() = this.esp.hashCode() + this.nomePet.hashCode()
    
    override fun equals(other: Any?):Boolean {
    	if(other == null){
        	return false
        }
        if(other !is Pet){
            return false
        }
        return (this.esp + this.nomePet) == (other.esp + other.nomePet)
    }
    
    override fun toString(): String {
            return "This is ${this.nomePet} he is a ${this.esp}" 
    } 
}

fun main() {
	val diferentesDogs:MutableSet<Cachorro> = mutableSetOf(Cachorro("Chiuaua"),Cachorro("Babalatera","Australia",10L),Cachorro("Babalatera","Australia",10L))
    diferentesDogs.add(Cachorro("Cachorro Tasmaniaco", "Tasmania"))
    for( cachorro in diferentesDogs){
        println(cachorro)
    }
    
    val meusPets : MutableSet<Pet> = mutableSetOf(Pet("Bob","Chiuaua"),Pet("Spike","Cachorro Tasmaniaco", "Tasmania"),Pet("Bob","Chiuaua"))
    
    for( cachorro in meusPets){
        println(cachorro)
    }
}

~~~
> To let and data class open, you will need to implement *equals()* and *hashcode*

### data class
It comes with class methods such as toString, hashCode and equals pre-implemented. <br>
When dealing with Set it is the way of removing duplicates. <br>
data classes cannot be extended



### abstract class and function
Abstract classes cannot create an object from it. Whenether it will forge an skeleton for our next classes. <br>
An abstract function must be implemented on the next classes, however, on abstract class it will show just the necessity of the method. <br>
Almost like an interface. <br>
It is "open" by necessity

### open class and open fun
It is a class that permits be extended.<br>
open functions permits override.

### enum class:
It is classes that defines constant well defined status. <br>
Do not accept extend

### sealed class:
It is classes that permits inheritance within the package only. <br>
It is a protect extension class.

### object keyword:
You can create a singleton object to organize objects for example:
~~~
val teste = object{
    var teste1 : Int = 1
    var teste2 : String = "yeah"
}
println(teste.teste1)
~~~
Another way is creating an object like with methods:
~~~
object teste {
    //properties and methods
}
fun main(){
    teste // you can use him normally
}
~~~
Finnaly, tou can use him to create a static method or atributes using **companion**:
~~~
class teste{
    companion object teste2{
        //properties and funcions
    }

}
fun main(){
    //Inside here, you can ignore teste2 name and use directly teste2 methods and properties stacly
    // To use the static methods or properties you dont use to instanciate
}

~~~


## Generics:
Used one you want to receive as parameter something from any type:
~~~
class MutableGeneric<E>(vararg item: E){

}
~~~

You can also create generics functions:
~~~
fun <E> funGeneric(vararg teste : E){
   //returning type <E>    
}
~~~

Example:
~~~
class MutableStack<E>(vararg items: E) {              // 1

  private val elements = items.toMutableList()

  fun push(element: E) = elements.add(element)        // 2

  fun peek(): E = elements.last()                     // 3

  fun pop(): E = elements.removeAt(elements.size - 1)

  fun isEmpty() = elements.isEmpty()

  fun size() = elements.size

  override fun toString() = "MutableStack(${elements.joinToString()})"
}
~~~

## Flux Controll:

### when:
It is used for *switch* case use <br>
There is two ways of using.
~~~
when(variable){ //statement
       condition -> action
       // ... lots of condition
       else -> defaultAction
}
~~~
~~~
val res = when(obj){ // as an expression
       condition -> returnSomething
       // ... lots of returnSomething
       else -> defaultReturn
}
~~~
> It usually uses Any type and return Any type

### Loops:

#### For-each:
FOR java like no longer exist...
~~~
for( variable in  ListVarible){
       // do Something
}
~~~

#### while and do-while:
Just like Java

#### Iterators:
To use for-each of class as if it was another class you can use an iterator!<br>
Example:
~~~
class Animal(val name: String, var idade: Int)

class Zoo(val animals: List<Animal>) {

    operator fun iterator(): Iterator<Animal> {             
        return animals.iterator()                           
    }
}

fun main() {

    val animals = listOf(Animal("zebra",10), Animal("lion",20));
    val zoo = Zoo(animals)

    for (animal in zoo) {   // class Zoo acting like a List of A                               
        println("Watch out, it's a ${animal.name}")
    }

}
~~~

#### Range
Also works in Char
 - ***n..m*** : de n até m **inclusive**
 > You can define the steps.
 >> ***n..m step z*** : de n até m de z em z
 - ***n until m*** : de n até m **exclusive**
 > m não incluso
 - ***n downTo m*** : de n até m DECRESCENTE **inclusive**
 

### Equality

- == To compare Structure (things that are inside or value)
- === To compare Pointer!


## Collections

### List
 It maintain the order, have an index.. Accept duplicates
 - listOf() creates an immutable list
 > Type List<>
 - mutableListOf() creates a mutable list
 > Type MutableList<>

 Be catious: when just '=' lists you are not copying it... instead you are mirroring them. So what you do in you of them, will be made in the other...<br>
 Another perception is that when using '=', it must be made at initialization


### Set
 Do not have an order and DO NOT accept duplicates
 - mutableSetOf<> creates a mutable SET
 > Type MutableSet<>
 - setOf<> creates a immutable set
 > Type Set<>

### Map:
 Key=value idea... the keys must be unique where value can be duplicate
 - mutableMapOf<key,value> creates a mutable SET
 > Type MutableMap<key,value> example: <br>
 > mutableMap(1 to 100, 2 tp 200, 3 to 500)
 - mapOf<key,value> creates an immutable map
 > Type Set<key,value>

### Usefull Functions:
 - .filter(lambda) : to filter a list
 - .map(lambda) : to transform something into other... nao desempacota
 - .any(lambda) : to return a boolean saying if contains or not.
 - .flatMap(lambda) : ele desempacota os elementos em uma unica lista fazer transformação


## Functions:

### Scope functions:

#### let:
You can call it from variables of diferent type:
 - It only runs if not null
    - It can be used to null protect
~~~
    str?.let{
        //functions where str cannot be null
    }

~~~
> You can create lots os .let inside another
.let works with "it" or a lambda functions variable

### run:
Does the same as let but "run" dont use it or lambda... It calls the variable directly "this"

### with:
Works with "this" directly. an example:
You can do:
~~~
class Cachorro(var nome:String, val especie:String )

fun main(){
    val teste = Cachorro("bob","chiuaua")
    println("${teste.nome} é um ${teste.especie}")
}
~~~
ou voce pode fazer:
   ~~~
class Cachorro(var nome:String, val especie:String )

fun main(){
    val teste = Cachorro("bob","chiuaua")
    with(teste){
        println("$nome é um $especie")
    }
}
~~~ 
> In this case with(object), you create an scope this = object, then you can directly call methods and atributes. <br>
> You could also use .run()

### apply:
You can use to alter values directly (when not private)

### also:
it works with lambda or "it" <br>
It is used to create a stream of functions with the creation of objects

### Infix Functions
It creates a new method for an object that can be called using infix notation: <br>
~~~
infix fun Int.teste(emSeguida : String) = //return something
println(someIntegerTeste teste "someStringTeste") // and it would return something 
~~~
> It can be used with methods to an specidfic action involving and class

### Operator Functions
You can override operators create infix Functions! <br>
It all to make your code more idiomatic

### High Order Functions
Functions that returns other Functions!!! <br>
You pass a function as an atribute.. So whenever function you pass into it: it will run! <br>
You can use it to create lambda functios on the fly or to use factory pattern.
Another way is returning another function: <br>
In this case you can indicate in the return a lambda operation, so, you can return a function directly

### Lambda Functions:
You can indicate the origin type or you can use 'it' (it can be used only when its a unique parameter).

### Extension Functions and Properties:
You simply create an AnObject.anotherFunction or AnObject.anotherProperie = //something or action <br> 
That way you will run perfectly as it was extended or it was a part of a class <br>
You can also create an extension Function in GENERIC!! Then in any data type, it will receive a new method or propertie

### Suspend Functions and coroutines
Coroutines are ASSYNC CALLs <br>
It is an indication to a function saying it might be assync.

## Execeptions:
In KOTLING EVERY EXCEPTION IS UNCHECKED!! BE CAREFULL! <br>
You might receive from compiler, however you can create yours...
~~~
throw Exception("Something Strange Happened")
~~~
To treat an exception:
> Finally will always be done... <br>
> Everything inside try will check for exception... if something happen, catch will "check" the error and try to treat, if possible. <br>
> You can be generable in catch using Superclass Throwable

~~~
try{

}catch(e:SomeException){
 //Optional or multiples from especialized to general
}finally{
 // Optional
}
~~~
You can also use try/catch as expression:
~~~
val div:double = try{a/b}catch(e: ArithmeticException){1000000000}
~~~
> try/catch sempre vai retornar o ultimo valor na expression... be carefull with the order when dealing with try/catch expression

Some Exception.. The same as JAVA! (java.lang)
 - ArithmeticException
 - ArrayIndexOutOfBoundsException
 - IOException
 - IllegalArgumentException("")
> When creating a throw in a class use a comment just on top of it: <br>
> @Throws(ExceptionName::class)

Throw also is an expression but it is a Nothing Type.
