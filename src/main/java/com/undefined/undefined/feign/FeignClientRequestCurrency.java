package com.undefined.undefined.feign;

import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;

@FeignClient(url = "${url.currency}",
        value = "currency-feign",
        configuration = FeignClientsConfiguration.class)
public interface FeignClientRequestCurrency {

    @RequestLine("GET /api/historical/{date}.json?app_id={appId}&base={base}&symbols={symbols}") // GET запрос по URL
    @Headers("Content-Type: application/json")
        // Тип, который мы ожидаем получить в ответе
    DTOResponseCurrency getExchangeRates(
            @Param("date") String date, // В url вместо {date} подставить string даты
            @Param("appId") String appId, // Id для того, чтобы послать запрос к сервису
            @Param("base") String base,
            @Param("symbols") String symbols
    );
}
