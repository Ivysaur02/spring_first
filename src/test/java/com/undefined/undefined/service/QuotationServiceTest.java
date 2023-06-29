package com.undefined.undefined.service;

import com.undefined.undefined.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class QuotationServiceTest extends AbstractTest {

    @Autowired
    private QuotationService quotationService;

    @Test
    void createQuotation() {
        quotationService.createQuotation("base", "rate", 1.456f, LocalDateTime.now());
        long count = quotationRepository.count();
        assertEquals(1, count);
    }
}