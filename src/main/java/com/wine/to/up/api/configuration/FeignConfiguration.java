package com.wine.to.up.api.configuration;

import com.wine.to.up.api.feign.KafkaServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Example of feign client
 */
@Configuration
public class FeignConfiguration {
    /**
     * Name of the service
     */
    @Value("${service.app.host}")
    private String serviceAppHost;

    /**
     * Configured feign client
     */
    @Bean
    public KafkaServiceClient getKafkaServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .client(new OkHttpClient())
                .target(KafkaServiceClient.class, "http://" + serviceAppHost);
    }
}
