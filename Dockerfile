# Use an official OpenJDK runtime as a parent image
FROM openjdk:18-ea-21-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/penalty-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8083

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
