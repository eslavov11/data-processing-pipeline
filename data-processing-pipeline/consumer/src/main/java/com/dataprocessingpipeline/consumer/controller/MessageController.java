package com.dataprocessingpipeline.consumer.controller;

import com.dataprocessingpipeline.consumer.service.MessageService;
import com.dataprocessingpipeline.dataaccess.dto.MessageDTO;
import com.dataprocessingpipeline.dataaccess.model.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
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

    @PostMapping("/messages")
    public void createMessage(@RequestBody Object message) {
        var messageModel = new MessageModel();
        messageModel.setMessage(message);

        this.service.create(messageModel);
    }
}
