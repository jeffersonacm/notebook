FROM openjdk:8
EXPOSE 8080
ADD target/notebook.jar notebook.jar
ENTRYPOINT ["java","-jar","/notebook.jar"]