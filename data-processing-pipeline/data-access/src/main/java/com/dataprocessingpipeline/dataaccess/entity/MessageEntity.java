package com.dataprocessingpipeline.dataaccess.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MessageEntity {
    @Id
    private String id;

    private Object message;
}
