package com.dataprocessingpipeline.dataaccess.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageModel {
    private Object message;
}
