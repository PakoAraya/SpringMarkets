FROM eclipse-temurin:21-jdk
ARG JAR_FILE=target/TechTestSupermarket-0.1.0-Alpha.jar
COPY ${JAR_FILE} app_testtechsuper.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_testtechsuper.jar"]