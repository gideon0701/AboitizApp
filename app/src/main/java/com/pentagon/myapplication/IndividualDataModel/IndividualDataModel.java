
package com.pentagon.myapplication.IndividualDataModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class IndividualDataModel {

    @SerializedName("last_update")
    private String mLastUpdate;
    @SerializedName("latitude")
    private String mLatitude;
    @SerializedName("longitude")
    private String mLongitude;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("units")
    private Units mUnits;

    public String getLastUpdate() {
        return mLastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        mLastUpdate = lastUpdate;
    }

    public String getLatitude() {
        return mLatitude;
    }

    public void setLatitude(String latitude) {
        mLatitude = latitude;
    }

    public String getLongitude() {
        return mLongitude;
    }

    public void setLongitude(String longitude) {
        mLongitude = longitude;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public void setResults(List<Result> results) {
        mResults = results;
    }

    public Units getUnits() {
        return mUnits;
    }

    public void setUnits(Units units) {
        mUnits = units;
    }

}
