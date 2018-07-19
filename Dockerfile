FROM openjdk:8-jre-slim
COPY ./target/url-shortner-0.0.1-SNAPSHOT.jar /usr/src/ankur/
WORKDIR /usr/src/ankur
EXPOSE 8080
CMD ["java", "-jar", "url-shortner-0.0.1-SNAPSHOT.jar"]