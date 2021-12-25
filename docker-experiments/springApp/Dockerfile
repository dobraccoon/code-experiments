#
# Build stage
#
FROM maven:3.6.3-jdk-11 AS build
RUN rm -rf /usr/local/tomcat/webapps/*
COPY spring-data-jpa-experiments/src /usr/local/tomcat/webapps/src
COPY spring-data-jpa-experiments/pom.xml /usr/local/tomcat/webapps/
RUN mvn -T 1C -f /usr/local/tomcat/webapps/pom.xml clean package -DskipTests
#
# Package stage
#
FROM tomcat:10.0.2-jdk11-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /usr/local/tomcat/webapps/target/spring-data-jpa-experiments-0.0.1-SNAPSHOT.jar /usr/local/tomcat/webapps/app.jar
RUN sh -c 'touch /usr/local/tomcat/webapps/app.jar'
ENTRYPOINT [ "sh", "-c", "java -Djava.security.edg=file:/dev/./urandom -Dspring.profiles.active=compose -jar /usr/local/tomcat/webapps/app.jar" ]
