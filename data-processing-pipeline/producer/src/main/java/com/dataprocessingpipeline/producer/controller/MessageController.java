package com.dataprocessingpipeline.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {
    private KingdomService service;

    @Autowired
    public DataController(KingdomService service) {
        this.service = service;
    }

    @PostMapping("/kingdom/create-for-user/{userId}")
    public List<KingdomViewModel> createKingdomsForUser(@PathVariable long userId) {
        return this.service.createForUser(userId);
    }
}
