package com.undefined.undefined;

import com.undefined.undefined.service.CurrencyService;
import com.undefined.undefined.service.GiphyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UndefinedApplication {

    public static void main(String[] args) {
        SpringApplication.run(UndefinedApplication.class, args);

        // Тест сервиса валют
        CurrencyService currencyService = new CurrencyService();
        var currencyData = currencyService.getQuotation("2023-06-25");
        System.out.println(currencyData);

        CurrencyService currencyService2 = new CurrencyService();
        var currencyData2 = currencyService2.getQuotation("2023-06-26");
        System.out.println(currencyData2);

        // Тест сервиса giphy
        GiphyService giphyService = new GiphyService();
        var giphyData = giphyService.getGiphy("Lol");
        System.out.println(giphyData);
    }

}
