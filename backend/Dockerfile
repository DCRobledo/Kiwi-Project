FROM maven:3.9.4-eclipse-temurin-17

WORKDIR /app
COPY . .

RUN mvn clean install -DskipTests

EXPOSE 8080 5005

CMD ["mvn", "-Dspring-boot.run.fork=false", \
"-Dspring-boot.run.jvmArguments=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", \
"spring-boot:run"]
