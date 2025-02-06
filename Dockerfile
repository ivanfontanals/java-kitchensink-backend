FROM openjdk:24-ea-21-jdk-slim

COPY build/libs/kitchensink-api.jar /opt/kitchensink-api.jar

ENV spring.profiles.active=dev
CMD ["java", "-jar", "/opt/kitchensink-api.jar"]
