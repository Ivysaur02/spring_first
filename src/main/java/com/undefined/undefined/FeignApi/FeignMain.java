package com.undefined.undefined.FeignApi;

import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.Map;
import java.util.Random;

public class FeignMain {
    public static void main(String[] args) {
        ApiClientCurrency clientCurrency = Feign.builder()
                .decoder(new GsonDecoder()) // JSON декодер, чтобы работать с JSON
                .target(ApiClientCurrency.class, "https://openexchangerates.org"); // ApiClient - то, что мы работаем с GET запросом, который мы описали в интерфейсе

        String date = "2023-06-25";
        String appId = "62702b9e6068461fbf4a38ae88b88547"; // Код Даниила (НЕ ТРОГАТЬ)
        String base = "USD"; // Изначальная ВАЛЮТА для котировки
        String symbols = "AUD,GBP,EUR,RUB"; // Курс

        ApiResponseCurrency responseCurrency = clientCurrency.getExchangeRates(date, appId, base, symbols); // Вызов GET запроса. Результат записывается в объект типа ApiResponse

        // Обработка полученного ответа. Объект response
        System.out.println("Disclaimer: " + responseCurrency.getDisclaimer());
        System.out.println("License: " + responseCurrency.getLicense());
        System.out.println("Timestamp: " + responseCurrency.getTimestamp());
        System.out.println("Base: " + responseCurrency.getBase());
        System.out.println("Rates:");
        for (Map.Entry<String, Double> entry : responseCurrency.getRates().entrySet()) {
            String currencyCode = entry.getKey();
            double rate = entry.getValue();
            System.out.println(currencyCode + ": " + rate);
        }
        ApiClientGiphy clientGiphy = Feign.builder()
                .decoder(new GsonDecoder()) // JSON декодер, чтобы работать с JSON
                .target(ApiClientGiphy.class, "https://api.giphy.com/v1/gifs");
        String apiKey = "AOk1bWf4UKBCe59mkHeHLNhweaQWNJiw";
        String giphyType = "lost"; // Код Даниила (НЕ ТРОГАТЬ)
        ApiResponseGiphy responseGiphy=clientGiphy.getGiphy(apiKey,giphyType);

        Random random = new Random();
        int randomIndex = random.nextInt(50);
        System.out.println("giphy url: " + responseGiphy.getData().get(randomIndex).getUrl());

    }
}
