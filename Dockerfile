FROM fabric8/java-centos-openjdk8-jdk
# Set working dir
WORKDIR /app
# Copy jar to /app dir
COPY spring-boot-app/target/spring-boot-app.jar app.jar
# Make port 8080 available to the world outside this container
EXPOSE 8080
# Run app.jar when the container launches
CMD ["java","-jar","app.jar"]