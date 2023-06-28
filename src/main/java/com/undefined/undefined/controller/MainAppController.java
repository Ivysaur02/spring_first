package com.undefined.undefined.controller;

import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import com.undefined.undefined.service.CurrencyService;
import com.undefined.undefined.service.GiphyService;
import com.undefined.undefined.service.QuotationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
//TODO Remove later
@Tag(name="Иницииация гифки относительно курса валют", description="Я не придумал")
public class MainAppController {
    private final CurrencyService currencyService;
    private final QuotationService quotationService;
    private final GiphyService giphyService;
    @Value("${exchange-rates.rate}")
    private String rate;
    @Value("${exchange-rates.base}")
    private String base;
    @GetMapping("/main_test")
    public ResponseEntity<String> main_test() {
        DTOResponseCurrency todayResponse=currencyService.getExchangeRate();
        DTOResponseCurrency yesterdayResponse=currencyService.getExchangeRate(LocalDate.now().minusDays(1).toString());
        Float todayCurr=todayResponse.getRates().get(rate);
        Float yesterdayCurr=yesterdayResponse.getRates().get(rate);
        quotationService.createQuotation(base, rate, todayCurr, Timestamp.valueOf(LocalDate.now().atStartOfDay()));
        quotationService.createQuotation(base, rate, yesterdayCurr, Timestamp.valueOf(LocalDate.now().minusDays(1).atStartOfDay()));
        if (todayCurr<yesterdayCurr)
            return ResponseEntity.ok(giphyService.getGiphy("rich").getUrl());
        else
            return ResponseEntity.ok(giphyService.getGiphy("broke").getUrl());
    }
}