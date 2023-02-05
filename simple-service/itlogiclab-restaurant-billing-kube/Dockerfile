# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jdk-alpine

#Working directory on the container 
WORKDIR /opt/app

#Copy the itlogiclabs-restaurant-billing.jar from local system to container
COPY target/itlogiclab-restaurant-billing-*.jar billing-app.jar

#Execute command ls -ltr <DIR> on the container
RUN ls -ltr /opt/app/

#Execute command for creating new directory on container
RUN mkdir -p /opt/multimoduleprojects/restaurant/logs

#Execute command for creating new directory on container. To check the content
RUN ls -ltr /opt/multimoduleprojects/restaurant/logs


ENTRYPOINT ["java","-jar","/opt/app/billing-app.jar"]