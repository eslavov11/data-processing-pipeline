package com.dataprocessingpipeline.dataaccess.repository;

import com.dataprocessingpipeline.dataaccess.entity.MessageEntity;
import com.dataprocessingpipeline.dataaccess.dto.MessageDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<MessageEntity, String> {
    List<MessageDTO> findAllBy();
}
