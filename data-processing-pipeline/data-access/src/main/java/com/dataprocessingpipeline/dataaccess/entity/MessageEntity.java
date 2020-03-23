package com.dataprocessingpipeline.dataaccess.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="messages")
public class MessageEntity {
    @Id
    private String id;

    private Object message;
}
