FROM openjdk:21
RUN adduser gestaoevento
USER gestaoevento:gestaoevento
COPY ./target/gestaoevento.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]