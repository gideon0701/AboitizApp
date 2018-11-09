package com.pentagon.myapplication;

import com.pentagon.myapplication.IndividualDataModel.IndividualDataModel;
import com.pentagon.myapplication.StationModel.StationsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface {

    @GET("stations/")
    Call<StationsModel> getAllStations();

    @GET()
    Call<IndividualDataModel> getStation(@Url String location);
}
