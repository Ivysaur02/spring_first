package com.undefined.undefined.repository;

import com.undefined.undefined.domain.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Integer> {
    List<Quotation> findByBase(String base);

    @Override
    List<Quotation> findAllById(Iterable<Integer> integers);
}
