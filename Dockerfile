FROM openjdk:11
EXPOSE 8085
WORKDIR /app

RUN apt-get update && apt-get install -y curl
RUN curl -o kaddem-2.3.jar -L "http://10.0.2.15:8081/repository/maven-releases/tn/esprit/kaddem/2.3/kaddem-2.3.jar"

ENTRYPOINT ["java", "-jar", "kaddem-2.3.jar"]