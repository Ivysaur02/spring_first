package com.undefined.undefined.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    // Интерсептор, тут можно подкладывать повторящиеся из API в API вещи, из разряда хедеров
    @Bean
    public RequestInterceptor oauth2FeignRequestInterceptor() {
        return requestTemplate -> requestTemplate.header("Content-Type", "application/json");
    }
}
