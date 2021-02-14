# person-assessment
Source code for the Person Management Application

Application is implemented using Spring Boot 2.4.2 Framework.

Following modules are used to build this Application.,

  - Spring Boot 2.4.2 (with embedded Tomcat)
  - Spring Security
  - Apache Derby (Embedded Datastore)
  - Swagger API Documentation
  - Spring Boot JUnit Testcases

# How to build

This project should be built using Apache Maven Build Tool. Check out the repostiroy, and run the below maven command to build this project 

    > mvn clean install
    
Pre-built library can be downloaded from the target folder 

    > assessment-1.0.0.jar
     
# Docker

This application has been published as Docker Image to the hub as gurusamyramesh14/assessment

  How to pull the docker image,
    
    > docker pull gurusamyramesh14/assessment:latest
    
  For running the docker image, 

     > docker run --rm -it --name assessment -p 8989:8989 -d docker.io/assessment:latest
     
# Docker Compose

Docker compose for this application is available. It can be downloaded from here and run as like below.,

    > docker-compose -f assessment-compose.yaml  up

# How to test

Once the application is deployed, then Swagger or the REST Endpoints can be accessed with the below URL

    > http://localhost:8989/assessment
    > http://localhost:8989/assessment/swagger-ui.html
    
# Other Information

While accessing the application, it will prompt for the Username/Password, then below credentials can be used.

Username/Password
-----------------------

    admin/admin
    user/password
