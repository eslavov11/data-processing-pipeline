package com.dataprocessingpipeline.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;

@Configuration
public class ApplicationConfig {
//    @Bean
//    public KafkaTemplate<String, Object> getKafkaTemplate() {
//        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(new HashMap<>()));
//    }
}
