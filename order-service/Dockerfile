FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/*.jar app.jar

#EXPOSE 8080
EXPOSE 8080 4573

ENTRYPOINT ["java", "-jar", "app.jar"]