package com.wine.to.up.demo.service.api.configuration;

import com.wine.to.up.demo.service.api.DemoServiceApiProperties;
import com.wine.to.up.demo.service.api.feign.KafkaServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign client for accessing demo service
 */
@Configuration
@RequiredArgsConstructor
public class DemoServiceFeignConfiguration {
    private final DemoServiceApiProperties demoServiceApiProperties;

    /**
     * Configured feign client
     */
    @Bean
    public KafkaServiceClient getKafkaServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .client(new OkHttpClient())
                .target(KafkaServiceClient.class, "http://" + demoServiceApiProperties.getHost());
    }
}
