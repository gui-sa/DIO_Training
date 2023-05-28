# WEB DEVELOPMENT with Spring Boot, KOTLIN and Java
 - JDK 17+ to Spring BOOT 3
 - TALEND API TESTER : an extension for CHROME to test APIs

## REST ARCHITECTURE
***API*** -  Application Programmin Interface... It is communicates two or more programs... It is an interface. <br>
They communicate using ***request/response - client/server*** <br>
Types of APIS:
 - SOAP : using XML
 - RPC : 
 - WEBSOCKET : more efficient than rest.. might have any format.
 - REST : uses JSON/XML to transfer data... Server sends back information
 > Uses HTTP <br>
 > ***STATELESS*** - server don't remenber what was asked... Another connection will be necessary. <

CRUD:
 - Create (usually POST)
 - Read (usually POST/GET)
 - Update (usually POST/PUT/PATCH)
 - Delete (usually POST/DELETE/PUT)

Usually an API rest has URL: <br>
http:// HOST:PORT/AplicationContext/Version/Resource/{parameters}
> Using GET method

# SPRING FRAMEWORK:
Inside SPRING FRAMEWORK, there more subtypes (modules). <br>
 - Spring BOOT 
 - SPRING WEB : REST API, TONCAT as container, Apache as server technology, and Spring MVC
 - SPRING DATA JPA : to access database
 ~~~
 implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
 runTimeOnly 'com.h2database:h2' 
 ~~~
 > H2 is a database driver...
 - SPRING SECURITY

It is a JAVA/KOTLIN/GROOVY Framework for backend. <br>
uses IoC and DI : beans (@component) it is a container... <br>
While running spring boot you will need to control dependencies... so Maven and Gradle is necessary. A dependency is SPRING BOOT STARTERS <br>
[Spring Initializr](https://start.spring.io/) : it is a tool to automaticly create a spring boot project. <br>

## Dependencies:
 - SPRING WEB : REST API, TONCAT as container, Apache as server technology, and Spring MVC
 - Validation: to validate some commom data
 - SPRING DATA JPA : to access database
 - FlywAy Migration: Version control for database. Like a git but to Database
 - H2 Database: in-memory database driver. It alsos brings a BROWSER console.

## Application Properties:

It is files such ***application.properties*** or ***application.yml***(.yml most used) <br>


# Three Tiers Architecture:
 
 - Presentation
 - Enterprise Rules
 - Data Access

CLIENT <-JSON->{ Controller <--> Service <--> Persistence Logic <--> Database }<br>

# JDBC
Java EE Database Connectivity :  Connect using pure SQL, your Java Aplication with Database

# JPA:
Java persistent API. <br>
Maps POJOs (Plain Old Java Objects) to the database... Those POJOs is entities <br>
JPA simplifies JDBC. <br>

# ORM
Unifies SQL with POO <br>
Interprets POJOs as database... SQL as Objects. <br>    

# Hibernate
It is an ORM TOOL! <br>

## H2
It is the database driver <br>
... There are others, such mysql, postgres, oracle etc...

# Using SPRING BOOT
 1. Create a Spring Boot project... It is a shortcut to use [SPRING INITIZALIZR](https://start.spring.io/)
 > It comes with Junit by default! Very nice! <br>
 > Junit works same way in Kotlin 

When running inside .../src the class that starts SPRINGBOOT is @SpringBootAplication
 2. Run and test it.
 3. Write application.properties or application.yml (you can change them up)
 > Usually they stays in resource folder in .../main
 4. Sets Database UP!
Access [documentation](https://strn.com.br/artigos/2018/12/11/todas-as-anota%C3%A7%C3%B5es-do-jpa-anota%C3%A7%C3%B5es-de-mapeamento/) for more annotations in JPA <br>
To set database Up using ORM you will need to import ***Annotation Class*** from ***jakarta.persisntence.*** package
 - @Entity : above the class to say that class is a Entity
 - @Table( name = "teste"): between Entity and the class to say the name of that table
 - @Column(props) : right behind the atributes to say the ORM that they are columns and to put especial comportaments
 > nullable = false : to NOT NULL <br>
 > unique = true : to saay they cannot repeat <br>
 - @Id : to say that property is a PRIMARY KEY
 - @GeneratedValue( props ) : ORM generates a value to you
 > strategy = GeneratedType.IDENTITY : to auto_increment <br>
 - @OneToMany() : one of this class can have MANY of this argument
 > fetch = FetchType.LAZY
 >> FetchType.LAZY : it just load when asked
 > cascade = CascadeType.Remove : to sets up Cascade property 
 >> CascadeType.Remove It will remove in cascade <br>
 >> CascadeType.PERSIST <br>
 >> You can use more than one config using arrayOf
 > mappedBy = "propInForengKey"
 - @Embedded : Your class is absorbing other class as its property
 - @Embeddable : above your class to say is is a package of property
To create the table:
~~~
spring:
  datasource:
    url: jdbc:h2:mem:credit_request_system_db
    username: pizza
    password: pizza123
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false
  jpa:
    hibernate:
      ddl-auto: create-drop

~~~
> jpa.hibernate.ddl-auto: create-drop will create and drop the tables automatically 
>> You WONT WANNA DO THAT in PRODUCTION
 5.  Create an Interface extending from JpaRepository<class,ID>
>It will bring CRUD already made.
 6. Create IServices interfaces pre implementing it
 7. Implements IServices interfaces using others classes
 > Dont forget to use @Service from .stereotype

## Setting up H2 database in application.yml
To know its properties consult [documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)!! <br>
Using H2... setting up using *.yml* here is an example:
~~~
spring:
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false
~~~
> Inside *spring application* <br>
> Sets up h2: <br>
> Enable console in route */h2-console*(localhost:8080/route) <br>
> Configurating it: do not permit it to be traces or to allow internet to access it directly... Security <br>
>> NOW, when reestarted, you will be able to access it on *localhost:8080/h2-console* <br>
>> To acces it: in the running process the URL will appear and its login. Enter that information and connect <br>
>> If you used "flyway versioning" there will be  "flyway-schema-history"... click on that and run its SQL.
To avoid that strange URL... You can use:
~~~
spring:
  datasource:
    url: jdbc:h2:mem:credit_request_system_db
    username: pizza
    password: pizza123
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false
~~~
> NOW, to enter, use that url passed (until jdbc:h2:mem it is pattern after that you can change) using username and password you had choosen
To it Create the sql at first time use:
~~~
spring:
  datasource:
    url: jdbc:h2:mem:credit_request_system_db
    username: pizza
    password:
  jpa:
    show-sql: true
    hibernate:
      properties:
       ddl-auto: create-drop
    #usually you dont do that because you will lost information

  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false

~~~
After that go to the sql and dump the schema to a file Vx__name.sql and put it inside db/migration folder <br>
To dump it in H2 database use:
~~~
SCRIPT SIMPLE TO 'dump.txt'
~~~
>Filter some commands...

Finally alter application.yml to:
~~~
spring:
  datasource:
    url: jdbc:h2:mem:credit_request_system_db
    username: pizza
    password:
  jpa:
    show-sql: true
    hibernate:
      properties:
        hibernate.format_sql: true
      # ddl-auto: create-drop
    #usually you dont do that because you will lost information
    # it will look for Vx__name.sql in db/migration
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false
~~~

# DTO
Data Transfer Object <br>
It is a project Pattern in which you receive a DTO from a ROUTE and it CALLS the service that calls a data transferer (that IS a controller) in which saves your data to your database.


# TROUBLESHOOTS:

## Wrote JPA notation and application.yml correctly however the tables wont be generated:
Your base project must be in the correct place... Other classes can be in other places (other packages, imports), but the main, MUST be in the local in which you configurated the gradle to see.

## I wrote something inside .../SRC, my code do not reference it and my code broke:
Everything inside .../src are looked and compiled. <br>
Dont put things inside here that are not in KOTLIN

## GRADLE DONT RUN... PROJECT BORN SO NOTHING CAN BE WRONG:
Tried running gradlew... after that all started working just fine. Felt it was because PORT was already in use however the stack tracer could track it.
~~~
./gradlew tasks
~~~
~~~
./gradlew bootRun
~~~
## PORT ALREADY IN USE (WINDOWS) - and you dont know which application is it:
~~~
netstat -aon | findstr <PORT>
~~~
~~~
tasklist | findstr <PID>
~~~
Then you will have aplication name that are using the port <br>
Go to Task Manager and kill it


# SpringBoot Security
They are *Servlet* filters
 - Configure Adapter
 - Database authentication
 - JWT - JSON Web Token
> When you are not athenticated the server will pass you a 401 : NOT AUTHORIZED

To use springBoot Security incluse:
 - Spring Security
 > It will create an Auth page with "user" as user and password by default 
 - Spring Web
 > For restifull apis application

 For default information you will need to change application.yml or application.properties:
 
 ~~~
 spring.security.user.name=pizza
 spring.security.user.password=pizza123
 spring.security.user.roles=USERS
 ~~~
 > It is just for settup initial... <br>
 > usually you wont do it

 Links:
  - [Basic Authentication](https://www.baeldung.com/spring-security-basic-authentication) 
  - [Database Auth](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/jdbc.html)
  > You authenticating use

