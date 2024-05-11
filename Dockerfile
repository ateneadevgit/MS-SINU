FROM openjdk:17-oracle
COPY target/ms-sinu.jar ms-sinu.jar
EXPOSE 8021
ENTRYPOINT ["java", "-jar", "/ms-sinu.jar"]