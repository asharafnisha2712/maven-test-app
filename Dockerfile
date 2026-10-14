FROM eclipse-temurin:17-jre-noble

WORKDIR /app
COPY target/maven-test-app-1.0.0.jar app.jar
USER 10001
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
