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
package com.wine.to.up.api.feign;

import com.wine.to.up.api.dto.ServiceMessage;
import com.wine.to.up.api.service.KafkaService;
import feign.RequestLine;

/**
 * Defines the parameters and paths of REST API of Kafka Service
 * <p>
 * Java feign client will be generated based on this declaration.
 * <p>
 * Ribbon load balancing client will resolve
 * the name of the service and request will be redirected to the particular instance.
 */
public interface KafkaServiceClient extends KafkaService {
    /**
     * {@inheritDoc}
     */
    @RequestLine(value = "POST /kafka/send/")
    void sendMessage(String message);

    /**
     * {@inheritDoc}
     */
    @RequestLine(value = "POST kafka/send/headers")
    void sendMessageWithHeaders(ServiceMessage messageWithHeaders);
}
