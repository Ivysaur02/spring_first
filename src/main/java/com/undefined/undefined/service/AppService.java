package com.undefined.undefined.service;

import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppService {
    private final CurrencyService currencyService;
    private final QuotationService quotationService;
    private final GiphyService giphyService;
    @Value("${exchange-rates.rate}")
    private String rate;
    @Value("${exchange-rates.base}")
    private String base;

    @GetMapping("/mainTest")
    public String getResult() {
        DTOResponseCurrency todayResponse = currencyService.getExchangeRate();
        DTOResponseCurrency yesterdayResponse = currencyService.getExchangeRate(LocalDate.now().minusDays(1).toString());
        Float todayCurr = todayResponse.getRates().get(rate);
        Float yesterdayCurr = yesterdayResponse.getRates().get(rate);
        quotationService.createQuotation(base, rate, todayCurr, Timestamp.valueOf(LocalDate.now().atStartOfDay()));
        quotationService.createQuotation(base, rate, yesterdayCurr, Timestamp.valueOf(LocalDate.now().minusDays(1).atStartOfDay()));
        if (todayCurr < yesterdayCurr)
            return "rich " + giphyService.getGiphy("rich").getUrl();
        else
            return "broke " + giphyService.getGiphy("broke").getUrl();
    }
}
