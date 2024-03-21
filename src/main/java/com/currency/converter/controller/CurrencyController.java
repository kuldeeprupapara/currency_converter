package com.currency.converter.controller;

import com.currency.converter.calculation.Conversion;
import com.currency.converter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CurrencyController {
    @Autowired
    private CurrencyService service;
    @Autowired
    private Conversion conversion;

    @GetMapping("/get")
    public Map<String, Double> getExchangeRates() {
        return service.getCurrencyExchangeRates();
    }

    @GetMapping("/get-currencies")
    public Map<String, String> getCurrency() {
        return service.getCurrencies();
    }

    @GetMapping("/convert/{toCurrency}/{amount}")
    public Double getExchanges(@PathVariable String toCurrency, @PathVariable Double amount) {
        return conversion.calculate(toCurrency, amount);
    }

    @GetMapping("/get-rate/{currency}")
    public Double getCurrentExchangeRate(@PathVariable String currency) {
        return service.getExchangeRate(currency);
    }
}
