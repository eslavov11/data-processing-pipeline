FROM openjdk:11-jre-slim

ADD target/data-processing-pipeline-consumer-*.jar /data-processing-pipeline-consumer.jar

ENTRYPOINT java -jar -Dspring.profiles.active=docker /data-processing-pipeline-consumer.jar 
