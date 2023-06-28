package com.undefined.undefined.controller;

import com.undefined.undefined.feign.dto.DTOData;
import com.undefined.undefined.feign.dto.DTOResponseCurrency;
import com.undefined.undefined.service.CurrencyService;
import com.undefined.undefined.service.GiphyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//TODO Remove later
@Tag(name="Название игорь контроллера", description="Описание контролера")
public class TestController {
    private final CurrencyService currencyService;
    private final GiphyService giphyService;

    @GetMapping("/test")
    public ResponseEntity<DTOResponseCurrency> test() {
        return ResponseEntity.ok(currencyService.getExchangeRate());
    }

    @GetMapping("/test1")
    public ResponseEntity<DTOData> test1() {
        return ResponseEntity.ok(giphyService.getGiphy());
    }
}
