package com.wine.to.up.test.api;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Defines values from properties. Can be autowired as a regular class
 */
@PropertySource("classpath:application-api.properties")
@Component
@Getter
public class ServiceApiProperties {
    @Value("${service.topic.name}")
    private String topicName;
}
