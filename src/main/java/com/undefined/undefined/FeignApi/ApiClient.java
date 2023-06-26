package com.undefined.undefined.FeignApi;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ApiClient {

    @RequestLine("GET /api/historical/{date}.json?app_id={appId}&base={base}&symbols={symbols}")
    @Headers("Content-Type: application/json")
    ApiResponse getExchangeRates(
            @Param("date") String date,
            @Param("appId") String appId,
            @Param("base") String base,
            @Param("symbols") String symbols
    );
}
