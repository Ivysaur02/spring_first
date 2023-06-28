package com.undefined.undefined.feign.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class DTOResponseCurrency {
    private String disclaimer;
    private String license;
    // Необязательно
    private long timestamp; // TODO переделать ли в норм дату???
    private String base;
    private Map<String, Float> rates; // Котировки представляются в виде мапа

    @Override
    public String toString() {
        return "{time: " + timestamp + ", " +
            "base: " + base + ", " +
            "rates: " + rates.toString() + "}\n";
    }
}

