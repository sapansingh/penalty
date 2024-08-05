FROM openjdk:8-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/penalty-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

