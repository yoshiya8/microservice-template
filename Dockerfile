FROM openjdk:8u131-jdk-alpine

ENTRYPOINT ["/usr/bin/java", "-jar", "/opt/odds/microservice-template.jar"]

ADD target/microservice-template.jar /opt/odds/microservice-template.jar
