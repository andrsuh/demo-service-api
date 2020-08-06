/*
 * Copyright (c) 2020 Andrsuh INC.
 * All Rights Reserved
 *
 * This software contains the intellectual property of Andrsuh INC or is
 * licensed to Dell EMC from third parties. Use of this software and the
 * intellectual property contained therein is expressly limited to the terms and
 * conditions of the License Agreement under which it is provided by or on behalf
 * of Andrsuh INC.
 */
package com.wine.to.up.api.service;

import com.wine.to.up.api.dto.ServiceMessage;

/**
 * Defines an interface for communicating with kafka
 */
public interface KafkaService {
    /**
     * Sends message to kafka topic
     *
     * @param topicName name of the topic
     * @param message   message
     */
    void sendMessage(String topicName, String message);

    /**
     * Sends message to kafka topic with headers
     *
     * @param topicName          name of the topic
     * @param messageWithHeaders message with headers
     */
    void sendMessageWithHeaders(String topicName, ServiceMessage messageWithHeaders);
}
