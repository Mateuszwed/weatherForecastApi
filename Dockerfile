FROM openjdk:17-jdk-alpine
ADD target/weatherForecastApi-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -jar weatherForecastApi-0.0.1-SNAPSHOT.jar