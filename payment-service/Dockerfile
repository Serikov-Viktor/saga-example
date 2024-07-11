# Start with a base image containing Java runtime
FROM adoptopenjdk:11-jre-hotspot

# Add Maintainer Info
LABEL maintainer="victor.serikov@outlook.com"

# The application's jar file
ARG JAR_FILE=./target/*.jar

# Add the application's jar to the container
ADD  ${JAR_FILE} payment-service.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "payment-service.jar"]