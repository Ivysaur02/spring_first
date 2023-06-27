package com.undefined.undefined;

import com.undefined.undefined.service.CurrencyService;
import com.undefined.undefined.service.GiphyService;
import com.undefined.undefined.service.QuotationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@SpringBootApplication
public class UndefinedApplication {

    private static CurrencyService currencyService;
    private static GiphyService giphyService;
    private static QuotationService quotationService;

    @Autowired
    public void setCurrencyService(CurrencyService currencyService) {
        UndefinedApplication.currencyService = currencyService;
    }

    @Autowired
    public void setGiphyService(GiphyService giphyService) {
        UndefinedApplication.giphyService = giphyService;
    }

    @Autowired
    public void setQuotationService(QuotationService quotationService) {
        UndefinedApplication.quotationService = quotationService;
    }

    public static void main(String[] args) {
        SpringApplication.run(UndefinedApplication.class, args);

        // Тест сервиса валют
        var currencyData = currencyService.getQuotation("2023-06-25");
        System.out.println(currencyData);

        var currencyData2 = currencyService.getQuotation("2023-06-26");
        System.out.println(currencyData2);

        // Тест сервиса giphy
        var giphyData = giphyService.getGiphy("Lol");
        System.out.println(giphyData);

        // Создание экземпляра сущности
        quotationService.createQuotation();
    }
}
