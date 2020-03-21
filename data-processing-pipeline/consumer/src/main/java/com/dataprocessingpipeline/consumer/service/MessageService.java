package com.dataprocessingpipeline.consumer.service;

import com.dataprocessingpipeline.dataaccess.model.MessageModel;
import com.dataprocessingpipeline.dataaccess.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    void create(MessageModel message);

    List<MessageDTO> getAll();
}
