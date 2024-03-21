FROM openjdk:17
EXPOSE 8080
ADD target/currency-converter.jar currency-converter.jar
ENTRYPOINT ["java","-jar","/currency-converter.jar"]