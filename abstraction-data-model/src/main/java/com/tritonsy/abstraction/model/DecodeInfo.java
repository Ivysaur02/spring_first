package com.tritonsy.abstraction.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class DecodeInfo extends AbstractEntity {

    private String fileName;

    private String decodedBarcode;
}
