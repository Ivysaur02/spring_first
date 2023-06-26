package com.undefined.undefined;

import com.undefined.undefined.FeignApi.ApiClient;
import com.undefined.undefined.FeignApi.ApiResponse;
import feign.Feign;
import feign.gson.GsonDecoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;


public class UndefinedApplication {
    public static void main(String[] args) {
        ApiClient client = Feign.builder()
                .decoder(new GsonDecoder()) // Используйте GsonDecoder для десериализации JSON
                .target(ApiClient.class, "https://openexchangerates.org");

        String date = "2023-06-25";
        String appId = "62702b9e6068461fbf4a38ae88b88547";
        String base = "USD";
        String symbols = "AUD,GBP,EUR,RUB";

        ApiResponse response = client.getExchangeRates(date, appId, base, symbols);

        // Обработайте полученный JSON-ответ
            System.out.println("Disclaimer: " + response.getDisclaimer());
            System.out.println("License: " + response.getLicense());
            System.out.println("Timestamp: " + response.getTimestamp());
            System.out.println("Base: " + response.getBase());
            System.out.println("Rates:");
            for (Map.Entry<String, Double> entry : response.getRates().entrySet()) {
            String currencyCode = entry.getKey();
            double rate = entry.getValue();
            System.out.println(currencyCode + ": " + rate);
        }
    }
}
