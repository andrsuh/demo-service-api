package com.wine.to.up.test.api.service;

import com.wine.to.up.test.api.dto.ServiceMessage;

public interface KafkaService {
    void sendMessage(String topicName, String message);
    void sendMessageWithHeaders( String topicName,  ServiceMessage message);
}
