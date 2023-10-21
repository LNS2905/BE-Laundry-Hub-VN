FROM openjdk:20-jdk

WORKDIR /app
COPY demoDB/target/spring-boot-aws-exe.jar app.jar
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]