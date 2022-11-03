# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jdk-alpine

WORKDIR /opt/app

COPY target/itlogiclab-restaurant-billing-*.jar billing.jar

RUN ls -ltr /opt/app/

RUN mkdir -p /opt/multimoduleprojects/restaurant/logs

RUN ls -ltr /opt/multimoduleprojects/restaurant/logs

ENTRYPOINT ["java","-jar","/opt/app/billing.jar"]