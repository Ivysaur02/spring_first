package com.undefined.undefined.feign.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;
@Getter
@Setter
public class DTOResponseCurrency {
    private String disclaimer;
    private String license;
    private long timestamp; // TODO переделать в настоящий тампстамп
    private String base;
    private Map<String, Double> rates; // Котировки представляются в виде мапа

    @Override
    public String toString(){
        return disclaimer+ " "+license+" "+ timestamp+" "+ base;
    }
}

