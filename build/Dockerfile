FROM openjdk:8-jdk-alpine
COPY ./target/jumia-task-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
COPY sample.db sample.db
ENTRYPOINT ["java","-jar","jumia-task-0.0.1-SNAPSHOT.jar"]