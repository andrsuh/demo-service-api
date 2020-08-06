package com.wine.to.up.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Defines values from properties. Can be autowired as a regular class
 */
@PropertySource("classpath:application-api.properties")
@ConfigurationProperties(prefix = "service")
@Setter
@Component
@Getter
public class ServiceApiProperties {
    private String topicName;
}
