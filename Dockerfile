#FROM openjdk:17
#
#WORKDIR /app
#
#COPY target/*.jar app.jar
#
#CMD ["java","-jar", "app.jar"]

# Stage 1: Build the JAR file
#FROM maven:3.9.7-amazoncorretto-21 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package -DskipTests
#
## Stage 2: Run the application
#FROM openjdk:17
#VOLUME /tmp
#EXPOSE 8080
#COPY --from=build /app/target/*.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

# First stage: build the application
FROM maven:3.9.7-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package -DskipTests

# Second stage: create a slim image
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]