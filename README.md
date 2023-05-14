# ACMEFlix application

A simple movie application that demonstrates how to build a RESTful  API using Spring Boot.

# Technologies Used
* Spring Boot
* Spring MVC
* Spring Data JPA
* H2 Database
* Maven

# Description

The purpose of this application is how show how to build RESTful using spring boot.  
You can think of it as a clone of Netflix.  
We have set movies and TV shows, that are generated(statically) at the startup of the app and they
are stored in our databases.  
We also have users and each user has multiple profiles showing their history.  
The profile history of each user is created randomly in the startup of the application, [GenerateProfiles](acmeflix-app/src/main/java/com/acmeflix/bootstrap/GenerateProfiles.java)  
All databases are embedded in the application using H2.

# How to run

This is an intellij project but you can also run it from the command line.
If you run it using itellij then evertying is set up.

## Prerequisites

If you decide to run it by hand you have you must have the below  
* Maven
* Java 17

And of course you should have set the JAVA_HOME envirometnal veriable

Go the root directory of the project.  

```bash
mvn clean package
java -jar .\acmeflix-app\target\acmeflix-app-2023.1.0.jar
``` 

# Usage

The application provides a simple RESTful API that allows you to perform CRUD (Create, Read, Update, Delete) operations on a 
collection of entities. You can interact with the API using tools such as curl or Postman.

## Endpoints

* GET users/: Returns all the registered users  
* GET users/{id}: Returns the user with the specified ID
* GET users/{id}/profiles: Returns all the profiles for the specified user ID. Shows also the viewed minutes
* GET users/{id}/profiles/history: The full history of the profile for the specified user ID
* DELETE users/{id}: Delete the specified user ID
* PUT users/{id}: Updates the user.
  
There are more endpoints but the above are the basics

## Databases

You can view the databases using this link: http://localhost:8081/h2-console/  

Credentials:  
username: sa  
password: sa  

They are defined here: [GenerateProfiles](acmeflix-app/src/main/resources/application.yml)  
