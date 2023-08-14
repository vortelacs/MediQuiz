FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY build/libs/MediQuiz-0.0.1-SNAPSHOT.jar MediQuiz-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/MediQuiz-0.0.1-SNAPSHOT.jar"]