FROM openjdk:8-jdk-alpine

COPY assessment-1.0.0.jar assessment.jar

ENTRYPOINT ["java","-jar","assessment.jar"]