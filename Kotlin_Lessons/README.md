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