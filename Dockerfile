# Etapa 1: Build de la aplicación con Maven y OpenJDK 17
FROM maven:3.9.9-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el contenido del proyecto al contenedor
COPY . .

# Compilar la aplicación y generar el .jar
RUN mvn clean package -DskipTests

# Etapa 2: Crear la imagen de ejecución con OpenJDK 17
FROM openjdk:17.0.1-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el .jar generado desde la etapa de compilación
COPY --from=build /app/target/MovieApp-0.0.1-SNAPSHOT.jar MovieApp.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "MovieApp.jar"]
