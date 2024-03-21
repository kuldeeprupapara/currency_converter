package com.currency.converter.calculation;

import com.currency.converter.dto.Currency;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculateConversion implements Conversion {
    @Override
    public Double calculate(String toConvert, Double amount) {
        if (toConvert == null || amount == null) {
            throw new NullPointerException();
        }
        final Map<String, Double> exchangeRates = Currency.getCurrencyExchangeRates();
        final Double value = exchangeRates.get(toConvert);
        if (amount == 1.00) {
            return value;
        }
        return value * amount;
    }
}
