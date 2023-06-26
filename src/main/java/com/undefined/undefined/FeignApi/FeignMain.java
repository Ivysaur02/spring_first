package com.undefined.undefined.FeignApi;

import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.Map;

public class FeignMain {
    public static void main(String[] args) {
        ApiClient client = Feign.builder()
                .decoder(new GsonDecoder()) // JSON декодер, чтобы работать с JSON
                .target(ApiClient.class, "https://openexchangerates.org"); // ApiClient - то, что мы работаем с GET запросом, который мы описали в интерфейсе

        String date = "2023-06-25";
        String appId = "62702b9e6068461fbf4a38ae88b88547"; // Код Даниила (НЕ ТРОГАТЬ)
        String base = "USD"; // Изначальная ВАЛЮТА для котировки
        String symbols = "AUD,GBP,EUR,RUB"; // Курс

        ApiResponse response = client.getExchangeRates(date, appId, base, symbols); // Вызов GET запроса. Результат записывается в объект типа ApiResponse

        // Обработка полученного ответа. Объект response
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
