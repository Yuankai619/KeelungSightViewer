FROM node:latest AS frontend-build
LABEL authors="Yuankai"
WORKDIR /app
COPY ./src ./src
COPY ./build.gradle ./settings.gradle ./
WORKDIR /app/src/main/frontend
RUN npm ci && npm install && npm run build watch

FROM gradle:7.6.4-jdk-focal AS backend-build
WORKDIR /app
COPY --from=frontend-build /app ./
RUN gradle clean build -x test

FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY --from=backend-build /app/build/libs/*.jar app.jar

CMD ["java", "-Dserver.port=${PORT}", "-jar","/app/app.jar"]

