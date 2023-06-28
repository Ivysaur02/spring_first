package com.undefined.undefined.service;

import com.undefined.undefined.domain.Quotation;
import com.undefined.undefined.repository.QuotationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class QuotationService {
    @Autowired
    private QuotationRepository quotationRepository;
    public void createQuotation(String base, String rate, Float value, Timestamp date) {
        // Создание нового кортежа
        Quotation quotation = new Quotation();
        quotation.setBase(base);
        quotation.setRate(rate);
        quotation.setValue(value);
        quotation.setDate(date);

        // Сохранение кортежа в базе данных
        quotationRepository.save(quotation);
    }

}