FROM openjdk:8-jdk-alpine
COPY ./target/pact-consumer-0.0.1-SNAPSHOT.jar /usr/src/consumer/
WORKDIR /usr/src/consumer
EXPOSE 9999
CMD ["java", "-jar", "pact-consumer-0.0.1-SNAPSHOT.jar"]