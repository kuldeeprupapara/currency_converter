package com.currency.converter.service;

import com.currency.converter.api.CurrencyConverterApiImpl;
import com.currency.converter.dto.Currency;
import com.currency.converter.dto.CurrencyObj;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyService {
    @Autowired
    CurrencyConverterApiImpl impl;

    private final Map<String, String> currencyObjMap = new LinkedTreeMap<>();
    private final Map<String, Double> exchangeRatesMap = new LinkedTreeMap<>();

    @Scheduled(initialDelay = 5000, fixedDelay = 3600000)
    public void init() {
        System.out.println("Started");
        CurrencyObj currencyObj = impl.get();
        Map<String, String> currency = impl.getCurrencyInfo();
        currencyObjMap.putAll(currency);
        exchangeRatesMap.putAll(currencyObj.getRates());
        Currency.getCurrencyInstance(currency, currencyObj);
    }

    public Map<String, String> getCurrencies() {
        return currencyObjMap;
    }

    public Map<String, Double> getCurrencyExchangeRates() {
        return exchangeRatesMap;
    }

    public Double getExchangeRate(String currency) {
        if (currency.isBlank()) {
            throw new NullPointerException("Currency should not be null");
        }
        return this.exchangeRatesMap.get(currency);
    }

}
