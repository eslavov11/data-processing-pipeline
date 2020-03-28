package com.dataprocessingpipeline.producer.controller;

import com.dataprocessingpipeline.producer.producer.Producer;
import com.dataprocessingpipeline.producer.websocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {
    private Producer producer;
    private WebSocketService webSocketService;

    @Autowired
    public MessageController(Producer producer, WebSocketService webSocketService) {
        this.producer = producer;
        this.webSocketService = webSocketService;
    }

    @PostMapping(value="/messages", consumes={"application/json"})
    public void createMessage(@RequestBody Object message) {
        this.webSocketService.sendMessage(message);
        this.producer.sendMessage(message);
    }
}
