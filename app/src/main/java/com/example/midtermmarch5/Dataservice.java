package com.example.midtermmarch5;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("3534")
    Call<Weather> getConsolidatedWeather();
}
