package com.dataprocessingpipeline.producer.producer.impl;

import com.dataprocessingpipeline.producer.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProducerKafkaImpl implements Producer {
    @Value(value = "${topic.name}")
    private String TOPIC;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public ProducerKafkaImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Object message) {
        log.debug(String.format("Producing message to topic %s -> %s", TOPIC, message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
