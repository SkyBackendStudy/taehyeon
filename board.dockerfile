FROM eclipse-temurin:17
CMD ["/", "clean", "package"]
ARG JAR_FILE_PATH=/build/libs/*.jar
COPY ${JAR_FILE_PATH} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]