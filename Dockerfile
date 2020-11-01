FROM openjdk:8-jdk-alpine
VOLUME /temp
ADD target/xkcdapiimage.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
