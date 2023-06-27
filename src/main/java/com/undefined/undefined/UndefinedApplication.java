package com.undefined.undefined;

import com.undefined.undefined.service.CurrencyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UndefinedApplication {

    public static void main(String[] args) {
        SpringApplication.run(UndefinedApplication.class, args);

        CurrencyService currencyService = new CurrencyService();
        var data = currencyService.getQuotation();
        System.out.println(data);
    }

}
