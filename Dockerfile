FROM maven:3.6.3-openjdk-8-slim AS builder
WORKDIR /opt/app
COPY . .
RUN mvn -e clean verify
FROM openjdk:18-slim
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar ./
ENV ENVIRONMENT=$ENVIRONMENT
ENV PORT=$PORT
EXPOSE $PORT
COPY /src/main/resources/application-${ENVIRONMENT}-docker.properties /opt/app/application.properties
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /opt/app/*.jar --spring.config.location=/opt/app/application.properties
