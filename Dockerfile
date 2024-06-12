FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests


FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /build/target/*.jar ./app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]


#FROM openjdk:17-jdk
#WORKDIR /app
#COPY target/techshop-0.0.1-SNAPSHOT.jar ./app.jar
#EXPOSE 8080
#CMD ["java","-jar","app.jar"]
