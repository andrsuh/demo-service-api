package com.wine.to.up.test.api.feign;

import com.wine.to.up.test.api.dto.ServiceMessage;
import com.wine.to.up.test.api.service.KafkaService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Primary
@FeignClient(name = "${application.address}/kafka")
public interface KafkaServiceClient extends KafkaService {
    @PostMapping(value = "/send/{topicName}")
    void sendMessage(@PathVariable String topicName, @RequestParam String message);

    @PostMapping(value = "/send/{topicName}")
    void sendMessageWithHeaders(@PathVariable String topicName, @RequestParam ServiceMessage message);
}
