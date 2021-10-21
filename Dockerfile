#Build
FROM maven:3.8.1-jdk-11-slim AS build
COPY src /workspace/src
COPY static /workspace/static
COPY pom.xml /workspace
RUN mvn -f /workspace/pom.xml clean package

#Package
FROM quay.io/sdase/openjdk-runtime:11-hotspot
ARG JAR_FILE=/workspace/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
COPY --from=build /workspace/static /static
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
