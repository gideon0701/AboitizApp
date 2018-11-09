
package com.pentagon.myapplication.StationModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Station {

    @SerializedName("elevation")
    private Long mElevation;
    @SerializedName("lat")
    private Double mLat;
    @SerializedName("lon")
    private Double mLon;
    @SerializedName("name")
    private String mName;
    @SerializedName("station_id")
    private Long mStationId;

    public Long getElevation() {
        return mElevation;
    }

    public void setElevation(Long elevation) {
        mElevation = elevation;
    }

    public Double getLat() {
        return mLat;
    }

    public void setLat(Double lat) {
        mLat = lat;
    }

    public Double getLon() {
        return mLon;
    }

    public void setLon(Double lon) {
        mLon = lon;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getStationId() {
        return mStationId;
    }

    public void setStationId(Long stationId) {
        mStationId = stationId;
    }

}
