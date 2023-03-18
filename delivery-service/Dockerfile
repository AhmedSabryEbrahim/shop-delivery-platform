# Fetching latest version of Java
FROM openjdk:18

# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/delivery-service-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8080



ENTRYPOINT ["java","-jar","/app/delivery-service-0.0.1-SNAPSHOT.jar"]