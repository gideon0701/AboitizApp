package com.pentagon.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("stations/")
    Call<StationsModel> getAllStations();
}
