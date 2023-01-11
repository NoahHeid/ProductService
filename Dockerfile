FROM openjdk:19
EXPOSE 8080
MAINTAINER Noah Heidrich
COPY target/Productservice-0.0.1.jar productservice.jar
ENTRYPOINT ["java","-jar","/productservice.jar"]