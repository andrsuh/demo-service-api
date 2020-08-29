package com.wine.to.up.demo.service.api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * Defines values from properties. Can be autowired as a regular class
 */
@PropertySources({
        @PropertySource("classpath:application-test-service-api.properties"),
        @PropertySource("classpath:application-test-service-api-${spring.profiles.active}.properties")
})
@ConfigurationProperties(prefix = "demo.service.api")
@Setter
@Component
@Getter
public class DemoServiceApiProperties {
    private String messageSentEventsTopicName;
    private String host;
}
