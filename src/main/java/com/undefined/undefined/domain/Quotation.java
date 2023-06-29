package com.undefined.undefined.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Quotation")
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String base;
    private String rate;
    @Column(columnDefinition = "numeric")
    private Float value;
    private LocalDateTime date;
}
