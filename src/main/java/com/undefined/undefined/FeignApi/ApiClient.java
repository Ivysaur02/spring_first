package com.undefined.undefined.FeignApi;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ApiClient {

    @RequestLine("GET /api/historical/{date}.json?app_id={appId}&base={base}&symbols={symbols}") //выполнить гет запрос по url
    @Headers("Content-Type: application/json") //тип который приходит в ответе
    ApiResponse getExchangeRates(
            @Param("date") String date, //в url вместо {date} подставить стрингу даты
            @Param("appId") String appId, //id чтобы послать запрос через сервис
            @Param("base") String base,
            @Param("symbols") String symbols
    );
}
