package com.dataprocessingpipeline.producer.controller;

import com.dataprocessingpipeline.producer.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MessageController {
    private Producer producer;

    @Autowired
    public MessageController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/messages")
    public void createMessage(@RequestBody Object message) {
        this.producer.sendMessage(message);
    }
}
