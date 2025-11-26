# Problemas con Render.com para levantar servicio
#FROM eclipse-temurin:21-jdk
#ARG JAR_FILE=target/TechTestSupermarket-0.1.0-Alpha.jar
#COPY ${JAR_FILE} app_testtechsuper.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app_testtechsuper.jar"]

# Probando Nueva configuracion
# Etapa 1: Compilar el proyecto
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copiar proyecto completo
COPY . .

# Dar permisos al mvnw
RUN chmod +x mvnw

# Construir JAR sin tests
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copiar solo el JAR final desde builder
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
