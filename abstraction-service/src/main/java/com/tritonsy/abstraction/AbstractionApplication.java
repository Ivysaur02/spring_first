package com.tritonsy.abstraction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class AbstractionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbstractionApplication.class, args);
    }

}
