package com.undefined.undefined.controller;

import com.undefined.undefined.feign.dto.DTOData;
import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import com.undefined.undefined.service.AppService;
import com.undefined.undefined.service.CurrencyService;
import com.undefined.undefined.service.GiphyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
//TODO Remove later
@Tag(name="Тесты", description="Я не придумал")
public class TestController {
    private final CurrencyService currencyService;
    private final GiphyService giphyService;
    private final AppService appService;
    @GetMapping("/test")
    public ResponseEntity<DTOResponseCurrency> test() {
        return ResponseEntity.ok(currencyService.getExchangeRate());
    }

    @GetMapping("/test1")
    public ResponseEntity<DTOData> test1() {
        return ResponseEntity.ok(giphyService.getGiphy());
    }
    @GetMapping("/mainAppTest")
    public ResponseEntity<String> appLogicTest() {return ResponseEntity.ok(appService.getResult());}
}
