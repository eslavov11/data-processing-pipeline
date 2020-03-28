package com.dataprocessingpipeline.producer.websocket.impl;

import com.dataprocessingpipeline.producer.websocket.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WebSocketServiceImpl implements WebSocketService {
    @Value(value = "${topic.name}")
    private String TOPIC;
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(Object message) {
        log.debug(String.format("Sending websocket message to topic %s -> %s", TOPIC, message));
        this.messagingTemplate.convertAndSend("/topic/" + TOPIC, message);
    }
}
