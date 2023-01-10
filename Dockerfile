FROM openjdk:latest
FROM maven:alpine
EXPOSE 8080
RUN mvn install -f pom.xml -DskipTests
MAINTAINER Noah Heidrich
COPY target/Productservice-0.0.1.jar productservice.jar
ENTRYPOINT ["java","-jar","/productservice.jar"]