FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rest-validation-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/rest-validation-demo-0.0.1-SNAPSHOT.jar"]