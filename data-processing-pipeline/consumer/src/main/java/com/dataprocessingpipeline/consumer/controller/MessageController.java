package com.dataprocessingpipeline.consumer.controller;

import com.dataprocessingpipeline.consumer.service.MessageService;
import com.dataprocessingpipeline.dataaccess.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {
    private MessageService service;

    @Autowired
    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/messages")
    public List<MessageDTO> getMessages() {
        return this.service.getAll();
    }
}
