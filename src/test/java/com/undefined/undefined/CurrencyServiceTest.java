package com.undefined.undefined;

import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import com.undefined.undefined.service.CurrencyService;
import com.undefined.undefined.service.GiphyService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CurrencyServiceTest extends AbstractTest{

    @Autowired
    private CurrencyService currencyService;

    static DTOResponseCurrency dtoResponseCurrency;

    @BeforeAll
    public static void init(){
        dtoResponseCurrency = new DTOResponseCurrency();

        dtoResponseCurrency.setDisclaimer("Usage subject to terms: https://openexchangerates.org/terms");
        dtoResponseCurrency.setLicense("https://openexchangerates.org/license");
        dtoResponseCurrency.setTimestamp(1687968000L);
        dtoResponseCurrency.setBase("USD");

        Map<String, Float> rates = new HashMap<>();
        rates.put("AUD", 1.510665F);
        rates.put("EUR", 0.917129F);
        rates.put("GBP", 0.79145F);
        rates.put("RUB", 86.425011F);

        dtoResponseCurrency.setRates(rates);
    }


    @Test
    void CheckSameDay(){
        DTOResponseCurrency receivedResponse = currencyService.getExchangeRate("2023-06-28");
        assertEquals(receivedResponse, dtoResponseCurrency);
    }

    @Test
    void CheckNotEqualsDay(){
        DTOResponseCurrency receivedResponse = currencyService.getExchangeRate("2023-06-20");
        assertNotEquals(receivedResponse, dtoResponseCurrency);
    }
}
