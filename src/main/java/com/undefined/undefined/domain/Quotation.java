package com.undefined.undefined.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter

@Entity
@Table(name = "Quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String base;
    private String rate;
    private float value;
}
