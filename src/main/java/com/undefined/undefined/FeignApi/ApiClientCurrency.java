package com.undefined.undefined.FeignApi;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ApiClientCurrency {

    @RequestLine("GET /api/historical/{date}.json?app_id={appId}&base={base}&symbols={symbols}") // GET запрос по URL
    @Headers("Content-Type: application/json") // Тип, который мы ожидаем получить в ответе
    ApiResponseCurrency getExchangeRates(
            @Param("date") String date, // В url вместо {date} подставить string даты
            @Param("appId") String appId, // Id для того, чтобы послать запрос к сервису
            @Param("base") String base,
            @Param("symbols") String symbols
    );
}
