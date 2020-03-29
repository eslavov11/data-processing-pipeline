FROM openjdk:11-jre-slim

ADD target/data-processing-pipeline-producer-*.jar /data-processing-pipeline-producer.jar

ENTRYPOINT java -jar -Dspring.profiles.active=docker /data-processing-pipeline-producer.jar
