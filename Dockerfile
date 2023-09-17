FROM openjdk:8
EXPOSE 8081
ADD target/registration.jar registration.jar
ENTRYPOINT ["java", "-jar", "/registration.jar"]