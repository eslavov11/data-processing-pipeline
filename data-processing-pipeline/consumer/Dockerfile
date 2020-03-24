FROM openjdk:11-jre-slim

ADD target/data-processing-pipeline-consumer-*.jar /data-processing-pipeline-consumer.jar

ENTRYPOINT java -Dspring.data.mongodb.uri=mongodb://mongo:27017/data-processing -Djava.security.egd=file:/dev/./urandom -jar /data-processing-pipeline-consumer.jar 
