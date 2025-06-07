FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /home/maven/app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy

RUN useradd -u 1000 -ms /bin/bash appuser

USER appuser

WORKDIR /home/appuser/app

ENV APP_ENV=production

COPY --from=builder /home/maven/app/target/harvestime-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]