package com.currency.converter.api;

import com.currency.converter.dto.CurrencyObj;
import jakarta.annotation.PostConstruct;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Map;

@Service
public class CurrencyConverterApiImpl {
    private final String APP_KEY = System.getenv("APP_ID");
    private CurrencyConverterApi api;

    @PostConstruct
    public void init() {
        final String BASE_URL = "https://openexchangerates.org/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(CurrencyConverterApi.class);
    }

    public CurrencyObj get() {
        return getData();
    }

    public Map<String, String> getCurrencyInfo() {
        return getCurrency();
    }

    private CurrencyObj getData() {
        return execute(this.api.get(APP_KEY));
    }

    private Map<String, String> getCurrency() {
        return execute(this.api.getCurrencies(APP_KEY));
    }

    private <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (getStatus(response.code(), response.isSuccessful(), response.errorBody())) {
                return response.body();
            }
        } catch (IOException e) {
            System.out.println("Error Occurred");
        }
        return null;
    }

    private boolean getStatus(int code, boolean successful, ResponseBody responseBody) {
        if (code == 200 && successful) {
            System.out.println("Success");
            return true;
        }
        assert responseBody != null;
        System.out.println(responseBody);
        return false;
    }

}
