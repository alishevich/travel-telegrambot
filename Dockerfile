FROM maven:3.8.1-jdk-11-slim AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package

FROM adoptopenjdk/openjdk11:ubi

COPY --from=MAVEN_BUILD target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]

