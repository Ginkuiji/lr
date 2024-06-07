# Сборка
FROM openjdk:22
WORKDIR /app
COPY --from=build /target/spring-rest-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]