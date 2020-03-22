package com.dataprocessingpipeline.producer.producer.impl;

import com.dataprocessingpipeline.producer.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerKafkaImpl implements Producer {

    private static final Logger logger = LoggerFactory.getLogger(ProducerKafkaImpl.class);

    @Value(value = "${topic.name}")
    private String TOPIC;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public ProducerKafkaImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Object message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
