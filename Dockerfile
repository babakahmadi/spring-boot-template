FROM openjdk:17-slim
RUN addgroup --system spring && adduser --disabled-password --ingroup spring --system spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources resources
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
