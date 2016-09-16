#<center>Pictopage</center>


##### Section1. For Dev Purposes:
* Run `bower install` to install all the js/css dependencies for the project.
* To start up the project on your local machine  run `mvn spring-boot:run`
* To start up the application in `Docker` check `section 2`.
* To create a docker image of the app you need to run `mvn package docker:build`. *(You can login)*


##### Section 2. Running the app on Docker

*PreRequisites*

	* Docker
	* Base Image (e.g. `Centos` or `Ubuntu`)

* Run `docker images` to check if the built image exists.
* Run the image : `docker run -d -p 8888:8888 --name {appname} {image-name}`