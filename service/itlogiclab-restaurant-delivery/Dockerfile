# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jdk-alpine

# specify default command
WORKDIR /opt/app/

RUN mkdir -p /opt/app/logs/archived
RUN ls -ltr /opt/app/
RUN pwd

COPY target/itlogiclabs-restaurant-delivery-*.jar delivery.jar
RUN ls -ltr /opt/app/

RUN mkdir -p /opt/multimoduleprojects/restaurant/logs
RUN ls -ltr /opt/multimoduleprojects/restaurant/logs

ENTRYPOINT ["java","-jar","/opt/app/delivery.jar"]