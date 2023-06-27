package com.undefined.undefined.service;

import com.undefined.undefined.feign.FeignClientRequestCurrency;
import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import feign.Feign;
import feign.gson.GsonDecoder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CurrencyService {
    private final String date = "2023-06-25";
    private final String appId = "62702b9e6068461fbf4a38ae88b88547"; // Код Даниила (НЕ ТРОГАТЬ)
    private final String base = "USD"; // Изначальная ВАЛЮТА для котировки
    private final String symbols = "AUD,GBP,EUR,RUB"; // Курс

    private final FeignClientRequestCurrency feignClientRequestCurrency = Feign.builder()
            .decoder(new GsonDecoder()) // JSON декодер, чтобы работать с JSON
            .target(FeignClientRequestCurrency.class, "https://openexchangerates.org");

    public DTOResponseCurrency getQuotation() {
        try {
            return feignClientRequestCurrency.getExchangeRates(date, appId, base, symbols);
        } catch (Exception e) {
            log.debug("Catch smth");
            throw new RuntimeException("Kek");
        }
    }
}
