FROM openjdk:17

ARG APP_JAR=*.jar

COPY ${APP_JAR} kpo-ticket-ordering-service.jar

ENTRYPOINT ["java", "-jar", "kpo-ticket-ordering-service.jar"]

EXPOSE 8081