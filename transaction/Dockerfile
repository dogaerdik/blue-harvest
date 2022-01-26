FROM adoptopenjdk/openjdk11:jdk-11.0.6_10-alpine-slim
COPY target/*.jar dap.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/dap.jar"]
