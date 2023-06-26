package com.undefined.undefined;

import com.undefined.undefined.FeignApi.ApiClient;
import com.undefined.undefined.FeignApi.ApiResponse;
import feign.Feign;
import feign.gson.GsonDecoder;
import java.util.Map;


public class UndefinedApplication {
    public static void main(String[] args) {
        ApiClient client = Feign.builder()
                .decoder(new GsonDecoder()) // JSON декодер чтобы работать с JSON
                .target(ApiClient.class, "https://openexchangerates.org"); //ApiClient-то что мы работаем с гет запросом, который мы описали в интерфейсе

        String date = "2023-06-25";
        String appId = "62702b9e6068461fbf4a38ae88b88547"; //код дани(НЕ ТРОГАТЬ)
        String base = "USD"; //изначальная ВАЛЮТА для котировки
        String symbols = "AUD,GBP,EUR,RUB";

        ApiResponse response = client.getExchangeRates(date, appId, base, symbols); //вызов гет запроса. и помещение результата в класс модель

        // Обработка полученного JSON. Он завёрнут в класс ApiResponse
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
