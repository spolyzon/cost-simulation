# Stage 1: Build Maven project
FROM maven:3.8.4-openjdk-11-slim
#FROM arm32v7/maven:3.8.4-eclipse-temurin-11
#ENV JAVA_OPTS="-XX:+UseSerialGC -Xss512k -XX:MaxRAM=72m"
WORKDIR /app
# Copy the parent pom.xml and download dependencies
#COPY pom.xml .
#RUN mvn dependency:go-offline -B
# Copy the entire project and build all modules
COPY . .
RUN mvn package -DskipTests
# Stage 2: Create the final image
#FROM openjdk:11-jre-slim
#FROM arm32v7/openjdk:11-jdk-slim
#WORKDIR /app
# Copy the built JAR files from each module
#COPY ./api/target/api-0.0.1-SNAPSHOT.jar ./api.jar
#COPY ./data/target/data-0.0.1-SNAPSHOT.jar ./data.jar
#COPY ./service/target/service-0.0.1-SNAPSHOT.jar ./service.jar
# ... Add more COPY statements for each module
# Set the command to run the application
EXPOSE 8080
CMD ["java", "-jar", "./target/simulation-0.0.1-SNAPSHOT.jar"]
#CMD ["sh", "-c", "java $JAVA_OPTS -jar ./service.jar"]
#CMD ["sh", "-c", "java -jar ./service.jar"]