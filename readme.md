# Spring-Boot-OAuth2 App

[![Docker Build Statu](https://img.shields.io/docker/build/artemas/artemas-spring-boot-oauth2.svg?style=flat-square)](https://github.com/Artemas-Muzanenhamo/artemas-spring-boot-oauth2)
[![Docker Pulls](https://img.shields.io/docker/pulls/artemas/artemas-spring-boot-oauth2.svg?style=flat-square)](https://github.com/Artemas-Muzanenhamo/artemas-spring-boot-oauth2)
[![Docker Automated buil](https://img.shields.io/docker/automated/artemas/artemas-spring-boot-oauth2.svg?style=flat-square)](https://github.com/Artemas-Muzanenhamo/artemas-spring-boot-oauth2)

## About

This is an application that provides a login using OAuth2. The stack for this application is AngularJS and Spring-Boot.
It also uses Spring-Social as it uses facebook's graph API.

## Setup
* Run `bower install` to install all the js/css dependencies for the project.
* To start up the project on your local machine  run `mvn spring-boot:run`
* To start up the application in `Docker` check `section 2`.
* To create a docker image of the app you need to run `mvn package docker:build`. *(You can login)*


### Running the app from Docker

#### PreRequisites

* Docker
* Base Image (e.g. `Centos` or `Ubuntu`)
	
#### Docker Instructions

* Run `docker images` to check if the built image exists.
* Run the image : `docker run -d -p 8888:8080 --name {appname} {image-name}`
