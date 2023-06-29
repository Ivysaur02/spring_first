package com.undefined.undefined;

import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import com.undefined.undefined.service.CurrencyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class CurrencyServiceTest extends AbstractTest {

    @Autowired
    private CurrencyService currencyService;

    static DTOResponseCurrency dtoResponseCurrency;

    @BeforeAll
    public static void init() {
        dtoResponseCurrency = new DTOResponseCurrency();

        dtoResponseCurrency.setDisclaimer("Usage subject to terms: https://openexchangerates.org/terms");
        dtoResponseCurrency.setLicense("https://openexchangerates.org/license");
        dtoResponseCurrency.setTimestamp(1687968000L);
        dtoResponseCurrency.setBase("USD");

        Map<String, Float> rates = new HashMap<>();
        rates.put("AUD", 1.496505F);
        rates.put("EUR", 0.912613F);
        rates.put("GBP", 0.784586F);
        rates.put("RUB", 85.37501F);


        dtoResponseCurrency.setRates(rates);

    }


    @Test
    void CheckSameDay() {
        Mockito.when(feignClientRequestCurrency.getExchangeRates(anyString(), anyString(), anyString(), anyString())).thenReturn(dtoResponseCurrency);
        DTOResponseCurrency receivedResponse = currencyService.getExchangeRate("2023-06-27");
        assertEquals(receivedResponse, dtoResponseCurrency);
    }

    @Test
    void CheckNotEqualsDay() {
        DTOResponseCurrency receivedResponse = currencyService.getExchangeRate("2023-06-20");
        assertNotEquals(receivedResponse, dtoResponseCurrency);
    }
}
