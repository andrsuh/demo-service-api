package com.wine.to.up.api.configuration;

import com.wine.to.up.api.ServiceApiProperties;
import com.wine.to.up.api.feign.KafkaServiceClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Example of feign client
 */
@Configuration
@RequiredArgsConstructor
public class ServiceFeignConfiguration {
    private final ServiceApiProperties serviceApiProperties;

    /**
     * Configured feign client
     */
    @Bean
    public KafkaServiceClient getKafkaServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .client(new OkHttpClient())
                .target(KafkaServiceClient.class, "http://" + serviceApiProperties.getHost());
    }
}
