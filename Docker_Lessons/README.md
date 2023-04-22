# Docker Training

Usually Docker containers run on top of Virtual Machines (in which are controlled by a hypervisor)...<br>
Those Virtual machines runs Server Especialized OS. <br>
Please install a Virtualization Software and on it, run a Linux Server image.

 1. [Virtualization Software](https://www.virtualbox.org/)
 2. [Linux Server](https://ubuntu.com/download/server) 
    - 4 GB RAM
    - Network: Bridged Adaptor
    - Note the DHCP IPv4

The access on those Linux Server will be made using SSH remote access so install it.

~~~ 
    ssh (user)@(Put here the VM IP)
~~~

Inside the VM (Virtual Machine) install docker. <br>

## More Info and References

An image is an HOW-TO (a blueprint) to create the isolated system... in this case the blue print to the container. <br>

A container is an INSTANCE of the image.<br>

You can create an image or using a ready one.
 - https://docs.google.com/presentation/d/1d9dyWZp0LBl9mHXanrR0nuZYjI3jW2YTuUOcmgWZE-Q/edit?usp=sharing
 - https://www.ibm.com/br-pt/topics/containers
 - https://www.redhat.com/pt-br/topics/containers
 - https://www.redhat.com/pt-br/topics/containers/containers-vs-vms
    - Para cada VM subimos tambem um novo Sistema Operacional. Não existe compartilhamento de recursos computacionais.
    - Os container tem somente o ambiente de execução necessario para rodar a aplicação e tem SO compartilhado entre si. Eles inclusiver partilham dinamicamente os recursos computacionais entre si. Essa levesa faz com que a Transferencia/Criação/Remoção de novas instâncias sejam performaticas
 - https://www.redhat.com/pt-br/topics/containers/what-is-docker
    - O Docker image é versionado e feito em camadas... Ele sempre aproveita essas camadas quando possivel.
 - https://programadriano.medium.com/principais-comandos-docker-f9b02e6944cd

Only Stopped containers can be removed.

## Docker commands

Shows running containers:
~~~
sudo docker ps
~~~

Shows all containers, including the stopped ones:
~~~
sudo docker ps -a
~~~

Shows all containers, including the stopped ones, showing just theirs IDs:
~~~
sudo docker ps -a -q
~~~

Shows all images:
~~~
sudo docker images
~~~

Stops a running container:
~~~
sudo docker stop [container_id]
~~~

Stops ***all*** running container:
~~~
sudo docker stop $(sudo docker ps -q)
~~~

Removes a Container:
~~~
sudo docker rm [container_id]
~~~

Removes ***all*** Container:
~~~
sudo docker rm $(sudo docker ps -a -q)
~~~

Removes an docker image:
~~~
sudo docker rmi [docker_image_id]
~~~

Removes ***all*** docker images:
~~~
sudo docker rmi $(sudo docker images)
~~~

Starts an stopped docker container:
~~~
sudo docker start [container_id]
~~~ 

Shows the container logs:
~~~
sudo docker logs [container_id]
~~~ 

Enters inside the CLI of a especific container:
> In this case the /bin/bash file is executed... It is the bash.
> Type "exit" to quit.
~~~
sudo docker exec -it [container_id] /bin/bash
~~~ 

Shows all docker networks:
~~~
sudo docker network ls
~~~ 

Creates a new docker networks:
~~~
sudo network create [Network_Name]
~~~ 

Removes a docker network:
~~~
sudo docker network rm [Network_Name]
~~~ 

Copy directory from Host to Container:
~~~
docker cp [hostDirectoryFrom] [containerID]:[containerDirectoryTo]  
~~~

Copy directory from Container to Host:
~~~
sudo docker cp [containerID]:[containerDirectoryFrom] [hostDirectoryTo]
~~~ 

Creating a Container From an Image (the usual):
> Flag ***-d*** creates a container but don't executes the bash 
> Flag ***-p*** maps an IP from the container to an IP in the Host
> Flag ***--net*** \[Binded_Network_Name] puts a container inside a docker Network 
> So a PORT coded inside a container is mapped to an host PORT ... A container starts with an IP an exposes an PORT when mapped. 
~~~
sudo docker run –-name [Container_Name] -d -p [Host_Port]:[Container_Port] [Image_Name]
~~~
