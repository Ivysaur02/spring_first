package com.undefined.undefined.service;

import com.undefined.undefined.feign.FeignClientRequestCurrency;
import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class CurrencyService {

    private final String DEFAULT_DATE = LocalDate.now().toString();
    @Value("${exchange-rates.app-id}")
    private String appId;
    @Value("${exchange-rates.base}")
    private String base;
    @Value("${exchange-rates.symbols}")
    private String symbols;

    private final FeignClientRequestCurrency feignClientRequestCurrency;

    public DTOResponseCurrency getExchangeRate() {
        try {
            return feignClientRequestCurrency.getExchangeRates(DEFAULT_DATE, appId, base, symbols);
        } catch (Exception e) {
            log.debug("Catch smth");
            throw new RuntimeException("Kek");
        }
    }

    public DTOResponseCurrency getExchangeRate(String date) {
        try {
            return feignClientRequestCurrency.getExchangeRates(date, appId, base, symbols);
        } catch (Exception e) {
            log.debug("Catch smth");
            throw new RuntimeException("Kek");
        }
    }
}
