FROM openjdk:11
EXPOSE 8083
COPY target/achat-1.0.jar achat-1.0.jar
ENTRYPOINT ["java", "-jar", "achat-1.0.jar"]