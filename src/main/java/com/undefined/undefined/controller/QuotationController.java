package com.undefined.undefined.controller;

import com.undefined.undefined.abstraction.api.QuotationApi;
import com.undefined.undefined.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class QuotationController implements QuotationApi {
    private final AppService appService;

    @Override
    public ResponseEntity<String> quotation() {
        return ResponseEntity.ok(appService.getResult());
    }
}
