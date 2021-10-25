FROM openjdk:12
ARG JAR=target/*.jar
COPY ${JAR} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]