
package com.pentagon.myapplication.StationModel;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class StationsModel {

    @SerializedName("last_update")
    private String mLastUpdate;
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
