package com.tritonsy.abstraction.config;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("Abstraction")
                        .description("Abstraction App")
                        .contact(new Contact("Alex Black", "", "tritonsy@gmail.com"))
                        .build())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Tag.class))
                .build();
    }
}
