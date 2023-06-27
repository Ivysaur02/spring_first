package com.undefined.undefined.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Quotation {
    @Id
    private UUID id;

    private LocalDate creationDate;
    private String text;
}
