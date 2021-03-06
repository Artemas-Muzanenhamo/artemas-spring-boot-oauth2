#<center>Pictopage</center>

[![Docker Build Statu](https://img.shields.io/docker/build/artemas/artemas-spring-boot-oauth2.svg?style=flat-square)](https://github.com/Artemas-Muzanenhamo/artemas-spring-boot-oauth2)
[![Docker Pulls](https://img.shields.io/docker/pulls/artemas/artemas-spring-boot-oauth2.svg?style=flat-square)](https://github.com/Artemas-Muzanenhamo/artemas-spring-boot-oauth2)
[![Docker Automated buil](https://img.shields.io/docker/automated/artemas/artemas-spring-boot-oauth2.svg?style=flat-square)](https://github.com/Artemas-Muzanenhamo/artemas-spring-boot-oauth2)


##### Section1. For Dev Purposes:
* Run `bower install` to install all the js/css dependencies for the project.
* To start up the project on your local machine  run `mvn spring-boot:run`
* To start up the application in `Docker` check `section 2`.
* To create a docker image of the app you need to run `mvn package`. *(You can login)*
* Tags-to-be-pushed can also be specified directly on the command line with
	`mvn ... docker:build -DpushImageTags -DdockerImageTags=latest -DdockerImageTags=another-tag`


##### Section 2. Running the app on Docker

*PreRequisites*

	* Docker
	* Base Image (e.g. `Centos` or `Ubuntu`)

### Commands - Docker

##### Check Images
- `docker images`

##### Run Image on Deamon
- `docker run -d -p {host-port}:{container-port} --name {appname} {image-name}`

##### Remove untagged images
- `docker rmi $(docker images -f dangling=true -q)`

##### Remove all stopped containers
- `docker rm $(docker ps -a -q)`

### Commands - Maven
- `mvn release:update-versions` : to update the Snapshot Version in the `pom.xml`
- `mvn --batch-mode release:update-versions -DdevelopmentVersion=1.2.0-SNAPSHOT` : POM will be set to the version 1.2.0-SNAPSHOT.
- `mvn clean install -docker-build` : Will build the Snapshot image and put it in the DockerHub Repo.
