# Step 1: Set the base image
FROM openjdk:17-jdk as build

# Step 2: Set the working directory
WORKDIR /workspace/app

# Step 3: Copy the project files to the working directory
COPY . .

# Step 4: Run the Gradle build
RUN chmod +x ./gradlew
RUN ./gradlew build

# Step 5: Copy the build output (JAR file) to the image
FROM openjdk:21-jdk-slim
COPY --from=build /workspace/app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

ENTRYPOINT ["java", "-Dserver.port=8080", "-jar", "/app.jar"]
