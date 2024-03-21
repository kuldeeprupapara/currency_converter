package com.currency.converter.api;

import com.currency.converter.dto.CurrencyObj;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface CurrencyConverterApi {
    @GET("/latest.json")
    Call<CurrencyObj> get(@Query("app_id") String key);

    @GET("/currencies.json")
    Call<Map<String, String>> getCurrencies(@Query("app_id") String key);
}
