# Data processing pipeline.

The data processing pipeline consists of producer, consumer and client applications.

- The producer is a Spring Boot application which is responsible for taking JSON input from a REST endpoint. The application then sends the message to all subscribed to the message websocket topic and finally sends it to a Kafka topic named message.
- For the JSON input, the client Angular application is provided, which has HTML form to send the JSON to the backend and also subscibes to the message websocket topic and receives all messages send to the producer application from the moment of subscribing.
- The consumer applciation is another Spring Boot application, which usese Spring Kafka and listens for messages from the Kafka topic the producer is sending messages to. Upon receiving the messages, the consumer application stores them in MongoDB and all the messages are available for query through a REST endpoint which returns an array of all JSON messages.

The data processing pipeline provides a docker-compose setup, which consists of zookeeper service, kafka service, mongodb service and finally services for the producer, consumer and client applicaitons.

The steps for running the project are as follows:
- make sure you have jdk 11+ installed
- install maven 3.6.0 +
- docker & docker compose
- 
-
- run - "cd ./pipeline.. && sudo mvn clean package  -Dmaven.test.skip=true" - this will build both Spring applications, since they have the same pom.xml parent
- make sure ports 4200, 9092, 8081,... are available on your host
- run - "docker-compose up"
- access angular client on localhost:4200 and send a JSON message through the form
- call GET on localhost:8082 (the consumer app) to get all the stored messages

Additional steps for running the project for development:
- install zookeeper and kafka
- install mongodb
- install latest version of node.js
- npm install -g @angular/cli
- start mongodb service
- start zookeeper server and then kafka broker server
- ng serve to start the client

