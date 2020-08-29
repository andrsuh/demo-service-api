package com.wine.to.up.demo.service.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Defines values from properties. Can be autowired as a regular class
 */
@PropertySource("classpath:application-test-service-api.properties")
@ConfigurationProperties(prefix = "demo.api")
@Setter
@Component
@Getter
public class DemoApiProperties {
    private String topicName;
    private String host;
}
