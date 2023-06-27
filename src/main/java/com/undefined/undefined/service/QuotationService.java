package com.undefined.undefined.service;

import com.undefined.undefined.domain.Quotation;
import com.undefined.undefined.repository.QuotationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class QuotationService {
    @Autowired
    private QuotationRepository quotationRepository;

    public void createQuotation() {
        // Создание нового кортежа
        Quotation quotation = new Quotation();
        quotation.setBase("Игорь");
        quotation.setRate("EUR");
        quotation.setValue(5.23f);
        quotation.setDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        // Сохранение кортежа в базе данных
        quotationRepository.save(quotation);
    }

    public void createQuotation(String base, String rate, Float value) {
        // Создание нового кортежа
        Quotation quotation = new Quotation();
        quotation.setBase(base);
        quotation.setRate(rate);
        quotation.setValue(value);
        quotation.setDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));

        // Сохранение кортежа в базе данных
        quotationRepository.save(quotation);
    }

}