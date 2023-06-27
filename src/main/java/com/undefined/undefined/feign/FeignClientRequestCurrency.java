package com.undefined.undefined.feign;

import com.undefined.undefined.config.FeignConfig;
import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${url.exchange-rates}",
    name = "currency-service",
    configuration = FeignConfig.class)
public interface FeignClientRequestCurrency {

    @GetMapping("/api/historical/{date}.json?app_id={appId}&base={base}&symbols={symbols}")
        // GET запрос по URL
        // Тип, который мы ожидаем получить в ответе
    DTOResponseCurrency getExchangeRates(
        @PathVariable("date") String date, // В url вместо {date} подставить string даты
        @PathVariable("appId") String appId, // Id для того, чтобы послать запрос к сервису
        @PathVariable("base") String base,
        @PathVariable("symbols") String symbols
    );
}
