# MYSQL LESSONS
An table is composed by Entities, Atributes and Keys <br>
Keys maintain table's relationship <br>
MySQL is free -> Database <br>
phpMyAdmin -> Database Manager <br>
> XAMPP: contains Apache, MySQL, phpMyAdmin, FTPServer
Why?
 - Organized
 - Atomic Data
   - Unique
   - Organized by Collums
 - Simplified Manipulation
 
To install mySQL just go to MySQL Community Server <br>
You can also install Mysql WorkBench... <br>
 1. Create a database
 2. Create tables WITH Primary Key
 > PRIMARY KEY(column1,column2,...) <br>
 > FOREIGN KEY (fk_column) REFERENCES othertable(column_id)
 > AUTO_INCREMENT <br>
 > NOT NULL
 * To create a relationship between them you will need FOREIGN KEY

## Acessing Database Server using CMD

Usually you will access the server using *SSH* <br>
> **-u** to user and **-p** to password:
~~~
mysql -u root -p password
~~~
CREATE DATABASE dio_training
~~~
show databases
~~~
~~~
use databaseName
~~~

## Types:
 - INT
 - VARCHAR
 - DATETIME

## SOME COMMANDS
 - CREATE TABLE pessoa (id int NOT NULL AUTO_INCREMENT PRIMARY KEY , nome varchar(20) NOT NULL,nascimento date NOT NULL)
 > It must have a primary key
 - INSERT INTO pessoa(nome, nascimento) VALUES ('teste','1990-04-20')
 - SELECT * FROM pessoa
   - SELECT nome FROM pessoa WHERE id=1
 - UPDATE pessoa SET nome = 'teste2' WHERE id = 1
 - DELETE FROM pessoa WHERE id=1
 > Select it first to ensure that you wont delete all the table
 - SELECT * FROM pessoa ORDER BY nome
 > SELECT * FROM pessoa ORDER BY nome DESC
 - SELECT COUNT(id) FROM pessoa GROUP BY genero
 - SHOW TABLES
 - ALTER TABLE pessoa ADD genero varchar(1) 
 - DROP DATABASE dio_training
 - DROP TABLE pessoa


## INNER JOIN
It wont bring nothing outside the equality.
 - SELECT * FROM pessoa JOIN cursos ON pessoas.id_cursos=cursos.id
 - SELECT * FROM pessoa,cursos WHERE (pessoa.id_cursos=cursos.id)
 > You can use AND statement to filter even more <br>
 > You can select the columm in '*' as *pessoa.nome, cursos.nome* for example

## OUTER JOIN

- SELECT * FROM pessoa LEFT JOIN cursos ON pessoas.id_cursos=cursos.id
> The left table dont need to be equal (JOIN as referencial)
- SELECT * FROM pessoa RIGHT JOIN cursos ON pessoas.id_cursos=cursos.id
> The right table dont need to be equal (JOIN as referencial)
- You can **UNION** SELECTS to create more than one outer join (they must have same instance number)
