# Étape de construction etetet
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copie des fichiers nécessaires pour la construction
COPY pom.xml .
COPY src ./src

# Construction de l'application
RUN mvn clean package -DskipTests

# Étape d'exécution
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copie du JAR depuis l'étape de construction
COPY --from=build /app/target/safarent-reev.jar app.jar

# Port exposé (doit correspondre à votre application.properties)
EXPOSE 8080

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]