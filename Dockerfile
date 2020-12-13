FROM maven:3.5-jdk-8-alpine as build

WORKDIR /app

COPY . /app

RUN mvn clean install

FROM java:8-jre

WORKDIR /app

COPY --from=0 /app/target/Seven-Senders-Challenge-0.0.1-SNAPSHOT.jar /app

ENTRYPOINT ["java","-jar","Seven-Senders-Challenge-0.0.1-SNAPSHOT.jar"]