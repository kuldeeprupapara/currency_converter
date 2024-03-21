package com.currency.converter.dto;

import com.google.gson.internal.LinkedTreeMap;

public class CurrencyObj {
    private String disclaimer;
    private String license;
    private Double timestamp;
    private String base;
    private LinkedTreeMap<String, Double> rates;

    public CurrencyObj() {
    }

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

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public LinkedTreeMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(LinkedTreeMap<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "CurrencyObj{" +
                "disclaimer='" + disclaimer + '\'' +
                ", license='" + license + '\'' +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
