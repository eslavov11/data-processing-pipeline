package com.dataprocessingpipeline.consumer.consumer;

import com.dataprocessingpipeline.consumer.service.MessageService;
import com.dataprocessingpipeline.dataaccess.model.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class Consumer {

    private MessageService messageService;

    @Autowired
    public Consumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Object> message) throws IOException {
        log.debug(String.format("Consumed message -> %s", message.value()));
        this.messageService.create(MessageModel
                .builder()
                .message(message.value())
                .build());
    }
}
