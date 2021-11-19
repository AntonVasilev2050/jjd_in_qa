FROM openjdk:11
COPY ./target/jjd_in_qa-0.0.1-SNAPSHOT.jar /usr/app/jjd.jar
EXPOSE 8080
EXPOSE 3306
ENTRYPOINT ["java", "-jar", "/usr/app/jjd.jar"]