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
 > PRIMARY KEY <br>
 > AUTO_INCREMENT <br>
 > NOT NULL

## Types:
 - INT
 - VARCHAR
 - DATETIME

## SOME COMMANDS
 - CREATE TABLE pessoa (id int NOT NULL AUTO_INCREMENT PRIMARY KEY , nome varchar(20),nascimento date, genero varchar(1))
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