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
@SuppressWarnings("SpringPropertySource")
//TODO create-service: change properties sources
@PropertySources({
        @PropertySource("classpath:application-demo-service-api.properties"),
        @PropertySource("classpath:application-demo-service-api-${spring.profiles.active:local}.properties")
})
//TODO create-service: change prefix (from your properties file)
@ConfigurationProperties(prefix = "demo.service.api")
@Setter
@Component
@Getter
//TODO create-service: rename
public class DemoServiceApiProperties {
    private String messageSentEventsTopicName;
    private String host;
}
