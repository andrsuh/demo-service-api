//TODO create-service: move ALL classes (not only this one) to correct package. F.e. for order-service-api all classes should be in "com.wine.to.up.order.service.api.*"
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
@SuppressWarnings("SpringFacetCodeInspection")
@Configuration
@RequiredArgsConstructor
//TODO create-service: rename
public class DemoServiceFeignConfiguration {
    private final DemoServiceApiProperties demoServiceApiProperties;

    /**
     * Configured feign client
     */
    //TODO create-service: do not forget to change bean name (method name)
    @Bean
    public KafkaServiceClient getKafkaServiceClient() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .client(new OkHttpClient())
                .target(KafkaServiceClient.class, "http://" + demoServiceApiProperties.getHost());
    }
}
