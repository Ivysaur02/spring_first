package com.undefined.undefined.repository;

import com.undefined.undefined.domain.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuotationRepository extends JpaRepository<Quotation, UUID> {

    List<Quotation> findByText();
}
