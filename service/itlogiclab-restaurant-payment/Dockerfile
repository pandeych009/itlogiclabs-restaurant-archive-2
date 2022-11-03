# Base Alpine Linux based image with OpenJDK JRE only
FROM openjdk:8-jre-alpine
# specify default command
WORKDIR /opt/app
# copy application WAR (with libraries inside)
COPY target/altimetrik-evaluation-parent-*.jar app.jar
##CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=test", "/app.jar"]
ENTRYPOINT ["java","-jar","app.jar"]
