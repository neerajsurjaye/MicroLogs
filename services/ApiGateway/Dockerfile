# ============================
# Build stage
# ============================
FROM maven:3.9.6-eclipse-temurin-17-focal AS build

# Create non-root user
RUN addgroup demogroup && adduser --ingroup demogroup --disabled-password demo

USER demo
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests


# ============================
# Runtime stage
# ============================
FROM eclipse-temurin:17-jre-alpine AS run
WORKDIR /app

# Create non-root user in Alpine
RUN addgroup -S demo && adduser -S -G demo demo

# Switch to non-root user
USER demo

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]
