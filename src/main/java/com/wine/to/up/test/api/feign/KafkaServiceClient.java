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
package com.wine.to.up.test.api.feign;

import com.wine.to.up.test.api.dto.ServiceMessage;
import com.wine.to.up.test.api.service.KafkaService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Defines the parameters and paths of REST API of Kafka Service
 * <p>
 * Java feign client will be generated based on this declaration.
 * <p>
 * We use placeholder in the {@link FeignClient#name()} field in order
 * for Ribbon load balancing client and Eureka discovery service to understand
 * the name of the service the request should be redirected to.
 */
@Primary
@FeignClient(name = "${application.address}/kafka")
public interface KafkaServiceClient extends KafkaService {
    /**
     * {@inheritDoc}
     */
    @PostMapping(value = "/send/{topicName}")
    void sendMessage(@PathVariable String topicName, @RequestParam String message);
    /**
     * {@inheritDoc}
     */
    @PostMapping(value = "/send/{topicName}/headers")
    void sendMessageWithHeaders(@PathVariable String topicName, @RequestParam ServiceMessage message);
}
