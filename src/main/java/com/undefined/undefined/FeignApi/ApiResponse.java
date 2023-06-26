package com.undefined.undefined.FeignApi;
import java.util.Map;

public class ApiResponse {
    private String disclaimer;
    private String license;
    private long timestamp; //TODO пределать в настоящим тампстамп
    private String base;
    private Map<String, Double> rates; //катировки представляются в виду мапа

    // Конструкторы, геттеры и сеттеры

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}

