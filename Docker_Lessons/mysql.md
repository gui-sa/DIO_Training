# mySql Container

Pulls its docker image:
~~~
sudo docker pull mysql
~~~

Create a container setting its root password to senha(please change the pass):
~~~
sudo docker run -e MYSQL_ROOT_PASSWORD=senha --name mysql-A -d -p 3306:3306 mysql
~~~

Access container bash:
~~~
sudo docker exec -it mysql-A bash
~~~

Connect via tcp protocol to the port using root user (inside container):
~~~
mysql -u root -p --protocol=tcp
~~~

## Be Carefull
If you **stop** de database container, and so start, it wont lose its data.
However, if you remove the container, it will lose its data(if it has not any external volumes).