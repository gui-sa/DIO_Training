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

Downloads an image from docker repo:
~~~
sudo docker pull [image_name]
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
> If you dont set network parameter to container, it will be set by default to bridge.
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

Creating a Container From an Image (the usual): <br>
> Flag ***-d*** creates a container but don't executes the bash  <br>
> Flag ***-p*** maps an IP from the container to an IP in the Host <br>
> Flag ***--net*** \[Binded_Network_Name] puts a container inside a docker Network <br> 
>> If you dont set network parameter to container, it will be set by default to bridge. <br>
> Flag ***-it*** a new container runs and in the same terminal, the container terminal opens. <br>
> Flag ***-e*** to add environment variable <br>
> Flag ***--volume=\[host_dir]:\[container_dir]*** to mount a volume in your container. <br>
> Flag ***-m*** limits its memory in MB <br>
> Flag ***--cpus** limits the percentage of cpus usage <br>
> So a PORT coded inside a container is mapped to an hot PORT ... A container starts with an IP an exposes an PORT when mapped. <br>
To containers that comes with interactive terminal:
~~~
sudo docker run –-name [Container_Name] -d -p [Host_Port]:[Container_Port] [Image_Name]
~~~
To container that don't come with interactive terminal:
~~~
sudo docker run –-name [Container_Name] -dti -p [Host_Port]:[Container_Port] [Image_Name]
~~~
To container that come with interactive terminal and binds a volume between host and container:
~~~
sudo docker run –-name [Container_Name] -d -v [/hostdir]:[/containerdir] -p [Host_Port]:[Container_Port] [Image_Name]
~~~
To container that don't come with interactive terminal and binds a volume between host and container:
~~~
sudo docker run –-name [Container_Name] -dti -v [/hostdir]:[/containerdir] -p [Host_Port]:[Container_Port] [Image_Name]
~~~

Shows all docker commands (older commands):
~~~
sudo docker --help
~~~ 

Shows all docker commands (new commands):
~~~
sudo docker container --help
~~~ 

To inspect containers informations:
~~~
sudo docker inspect [container_name]
~~~ 

To inspect containers computational resource consumption informations:
~~~
sudo docker stats [running_container_name]
~~~ 

To update resource consumption in an existing container:
> Flag ***-m*** limits its memory in MB <br>
> Flag ***--cpus** limits the percentage of cpus usage 
~~~
sudo docker update [container_name] -m [memory]M --cpus [0 to 1 using dot]
~~~ 

To docker server information:
~~~
sudo docker info
~~~ 

## Docker Mounts or Volumes

To look after informations about volumes run:

~~~
sudo docker inspect [container_name]
~~~

It will show you a lot of information... Go to "Mounts" and then destination <br>
There are three types of mounts:

 - **bind** is a type of volume where a host space is linked to the container space. <br>
 ~~~
   docker run -v [/hostdir]:[/containerdir] [image]
 ~~~
    Another way to run a volume:
 ~~~
   docker run --mount type=bind,src=[host_dir],dsr=[container_dir],[none,ro] [image] 
 ~~~
 - **named or volume** is a type of bind where you dont especify the host directory (managed by docker)
   Create a new docker volume:
 ~~~
   docker volume create [volume_name]
 ~~~
   To remove a docker volume:
 ~~~
docker volume rm [volume_name]
 ~~~
   To remove ***all*** docker volumes:
 ~~~
   docker volume prune
 ~~~
   Bind docker volume to your container:
 ~~~
   docker run -v [volume_name]:[container_dir] [image]
 ~~~
 - **volume linked to the dockerfile**

## DockerFile (Creating your own docker image):

Usually starts by a base image for example:
 - Ubuntu
 - Debian
 - Alpine (lightest linux)

> Direct coding images (such as  node or python) are usually larger than using a OS base. <br>
> Smaller containers are cheaper and more performatic <br>
> Usually inside it, run ***apt update*** <br>
> Then you install what you want <br>
> Finally you clean the repos ***apt clean***

 1. Create a directoty in your host.
 2. Put inside that directoy all files that you will need/want
 3. Create a ***Dockerfile*** (written that way)
 4. Inside dockerfile:
   - **FROM** \[docker_image_base]
   - **RUN** \[Container_commands to run... you can run multiples by separing them using &&] 
   - **COPY** \[host_file_dir] \[container_file_dir including its new name]
   - **CMD** \[Command] \[container_directory]
> There are others functions such as ***WORKDIR*** that moves you inside your image, like a *cd* command... Even thought you have that option it is preferable that you put absolute paths. <br>
> Function ***ADD*** copys an *.tar* file from host and extracts it inside container. <br>
> Function ***ENV*** creates a .env inside your *workdir* directory and saves a enviroment data inside it <br>
> Function ***LABEL*** saves a label in your container... example> LABEL description = "example label" <br>
> Funtion ***VOLUME*** binds files inside your container to a volume <br>
> Function ***EXPOSE*** expose a port to a possible host.
> *From* will pull its base image, *RUN* can for example: install things inside it, *COPY* to get files from host to container and *CMD* to run an aplication inside it just when you run a container.
 5. Create the image:
~~~
   docker build [relative_host_directory_to_Dockerfile] -t [image_name]
~~~
> Flag ***-t*** names it;<br>
> Flag ***-f*** to look for Dockerfile with others names or directories. <br>
> The relative relative_host_directory_to_Dockerfile needs to be in a */home* like directory. <br>

### MULTISTAGE IMAGE

   When creating an image, you use another image to generate something (artifact) and then copy it inside another image (usually smaller and more performatic).<br>
   They usually use binaries created by GO docker (heavy image).. Create a bin from it and copy inside an alpine that are light just to run its binaries.

### Pushing repos to Docker Hub
   
   You need to especify user when creating image using by ***-t*** flag (example: *-t dockerhub_user/nome_image:1.0*) 

   ~~~
   docker push [image_name:version]
   ~~~

   In a company, you can create a closed private server:
   1. Create a Virtual Machine linux server
   2. Install Docker
   3. Pull ***registry*** docker image into your VM
   ~~~
   docker run  -d -p 5000:5000 --restart=always --name [container_name] registry:[version]
   ~~~
   4. Logout from dockerhub:
   ~~~
   docker logout
   ~~~
   5. In your other server (where you are running an image), retag your existing image
   ~~~
   docker image tag [your_image_tag] [Docker_Server_IP]:[PORT usually 5000]/[image_name]:[version]
   ~~~
   6. Checks if you can access it and sees its images(in this case you are using v2).. will return a JSON
   ~~~
   curl [Docker_Server_IP]:[PORT usually 5000]/v2/_catalog
   ~~~
   7. Push your retagged image to the server
   ~~~
   docker push [rettaged_image_full_name]
   ~~~
> It might give you an error... If it is local, you can just create a file in */etc/docker/daemon.json*<br>
> Inside that file put *{"insecure-registries":\["IP:PORT"]}*<br>
> Restart docker by *systemctl restart docker*

   8. Now you can pull its image from your server
   ~~~
   docker pull [fullname_image_from_dockerhub_server]
   ~~~

## Docker Compose:
   Organize and sincronize multiple containers at once!<br>
   Use file *.yaml* <br>
   Always [follow docker version](https://docs.docker.com/compose/compose-file/compose-versioning/)... Docker compose is fragile so always shows its version and docker version... <br>
   ~~~
   docker --version
   ~~~
   ~~~
   docker compose version
   ~~~
   
   To [update docker compose](https://docs.docker.com/compose/install/linux/):
> According to documentation, docker-compose (v1) is deprecated <br>
> An usable version will come with docker, however, it is importante that you use same docker compose version as your company... To change it, just point the correct version in .yaml file
   To install docker compose
   ~~~
   apt-get update
   ~~~
   ~~~
   apt-get install docker-compose
   ~~~

   Even thought it is version 1x version, when running *docker-compose* it will run *docker compose max version* of your docker:
   > It will lookup for *.yml* or *.yaml* file and run it.<br>
   > Make sure thar host port are available when upping a docker-compose.
   ~~~
   docker-compose up -d
   ~~~
   File [compose_me.yml](./compose_me.yml) is an example of an docker-compose for na mysql and adminer aplication. <br>

   To get containers down just use:
   ~~~
   docker-compose down
   ~~~


## Networks:
 - ***host***: Flag *-p* is not needed and so, the ports are mapped to the machine IP and exposed to the local network. Only works on linux, basically.
 - ***bridge***: Flag *-p* is needed and so, the container port is mapped to the host port... the container port is separated between others possibles networks. Works on every OS (that runs Docker rs)...

 > To connect bridge type to the [outside world](https://docs.docker.com/network/bridge/).

Run the commands (they do not persist over reboot and will bring your bridge network to host network).
~~~
sysctl net.ipv4.conf.all.forwarding=1
~~~
~~~
sudo iptables -P FORWARD ACCEPT
~~~

The problem is that by running these commands, you expose **all** your ports over local network. Which might not be a good idea.

## Interesting Dockers:

 - **httpd** Creates an Apache server that ups an index.html, style.css and script.js... Static web sites.
 - **ubuntu** Creates an ubuntu (with no interactive terminal and GNOME) that servers a linux
 - **mysql** Creates a mysql database server
 - **adminer** To access the sql server
 - **php** Creates an php aplication... you need to inform if you want to include apache to it
   - **php:\[version]-apache** Then it comes with apache
 