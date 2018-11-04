package com.pentagon.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class StationsModel {

    @SerializedName("last_update")
    private String last_update;
    Units UnitsObject;
    ArrayList<Object>results = new ArrayList<Object> ();

    // Getter Methods

    public String getLast_update() {
        return last_update;
    }

    public Units getUnits() {
        return UnitsObject;
    }

    // Setter Methods

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public void setUnits(Units unitsObject) {
        this.UnitsObject = unitsObject;
    }
}
  class Units {
    @SerializedName("time")
    private String time;
      @SerializedName("temperature")
    private String temperature;
      @SerializedName("wind_speed")
    private String wind_speed;
      @SerializedName("solar_radiation")
    private String solar_radiation;
      @SerializedName("mean_sea_level_pressure")
    private String mean_sea_level_pressure;
      @SerializedName("rain")
    private String rain;
      @SerializedName("dewpoint")
    private String dewpoint;
      @SerializedName("wind_gust")
    private String wind_gust;
      @SerializedName("wind_direction")
    private String wind_direction;
      @SerializedName("heat_index")
    private String heat_index;
      @SerializedName("total_cloud_cover")
    private String total_cloud_cover;
      @SerializedName("rain_probability")
    private String rain_probability;


    // Getter Methods

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public String getSolar_radiation() {
        return solar_radiation;
    }

    public String getMean_sea_level_pressure() {
        return mean_sea_level_pressure;
    }

    public String getRain() {
        return rain;
    }

    public String getDewpoint() {
        return dewpoint;
    }

    public String getWind_gust() {
        return wind_gust;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public String getHeat_index() {
        return heat_index;
    }

    public String getTotal_cloud_cover() {
        return total_cloud_cover;
    }

    public String getRain_probability() {
        return rain_probability;
    }

    // Setter Methods

    public void setTime(String time) {
        this.time = time;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public void setSolar_radiation(String solar_radiation) {
        this.solar_radiation = solar_radiation;
    }

    public void setMean_sea_level_pressure(String mean_sea_level_pressure) {
        this.mean_sea_level_pressure = mean_sea_level_pressure;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public void setDewpoint(String dewpoint) {
        this.dewpoint = dewpoint;
    }

    public void setWind_gust(String wind_gust) {
        this.wind_gust = wind_gust;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public void setHeat_index(String heat_index) {
        this.heat_index = heat_index;
    }

    public void setTotal_cloud_cover(String total_cloud_cover) {
        this.total_cloud_cover = total_cloud_cover;
    }

    public void setRain_probability(String rain_probability) {
        this.rain_probability = rain_probability;
    }
}
