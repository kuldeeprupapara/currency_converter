package com.currency.converter.dto;

import java.util.Map;

public class Currency {
    private static Currency currency;
    private static Map<String, String> currencyInfo;
    private static Map<String, Double> currencyExchangeRates;

    private Currency(Map<String, String> currencyInfo, Map<String, Double> currencyExchangeRates) {
        Currency.currencyInfo = currencyInfo;
        Currency.currencyExchangeRates = currencyExchangeRates;
    }

    public static Currency getCurrencyInstance(Map<String, String> info, CurrencyObj obj) {
        if (currency == null) {
            currency = new Currency(info, obj.getRates());
            return currency;
        }
        return currency;
    }

    public static Map<String, String> getCurrencyInfo() {
        return currencyInfo;
    }

    public static Map<String, Double> getCurrencyExchangeRates() {
        return currencyExchangeRates;
    }
}
