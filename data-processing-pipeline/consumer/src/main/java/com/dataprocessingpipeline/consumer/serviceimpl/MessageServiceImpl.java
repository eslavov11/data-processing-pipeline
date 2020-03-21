package com.dataprocessingpipeline.consumer.serviceimpl;

import com.dataprocessingpipeline.dataaccess.model.MessageModel;
import com.dataprocessingpipeline.dataaccess.dto.MessageDTO;
import com.dataprocessingpipeline.consumer.service.MessageService;
import com.dataprocessingpipeline.dataaccess.entity.MessageEntity;
import com.dataprocessingpipeline.dataaccess.repository.MessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public MessageServiceImpl(MessageRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(MessageModel message) {
        var messageEntity = this.modelMapper.map(message, MessageEntity.class);

        this.repository.save(messageEntity);
    }

    @Override
    public List<MessageDTO> getAll() {
        return this.repository.findAllBy();
    }
}
