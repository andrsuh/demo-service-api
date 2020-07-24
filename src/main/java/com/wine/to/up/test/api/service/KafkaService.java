package com.wine.to.up.test.api.service;

public interface KafkaService {
    void sendMessage(String topicName, String message);
}
