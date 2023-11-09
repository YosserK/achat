FROM openjdk:11
EXPOSE 8082
COPY target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]