
package com.pentagon.myapplication.StationModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Units {

    @SerializedName("dewpoint")
    private String mDewpoint;
    @SerializedName("heat_index")
    private String mHeatIndex;
    @SerializedName("mean_sea_level_pressure")
    private String mMeanSeaLevelPressure;
    @SerializedName("rain")
    private String mRain;
    @SerializedName("rain_probability")
    private String mRainProbability;
    @SerializedName("solar_radiation")
    private String mSolarRadiation;
    @SerializedName("temperature")
    private String mTemperature;
    @SerializedName("time")
    private String mTime;
    @SerializedName("total_cloud_cover")
    private String mTotalCloudCover;
    @SerializedName("wind_direction")
    private String mWindDirection;
    @SerializedName("wind_gust")
    private String mWindGust;
    @SerializedName("wind_speed")
    private String mWindSpeed;

    public String getDewpoint() {
        return mDewpoint;
    }

    public void setDewpoint(String dewpoint) {
        mDewpoint = dewpoint;
    }

    public String getHeatIndex() {
        return mHeatIndex;
    }

    public void setHeatIndex(String heatIndex) {
        mHeatIndex = heatIndex;
    }

    public String getMeanSeaLevelPressure() {
        return mMeanSeaLevelPressure;
    }

    public void setMeanSeaLevelPressure(String meanSeaLevelPressure) {
        mMeanSeaLevelPressure = meanSeaLevelPressure;
    }

    public String getRain() {
        return mRain;
    }

    public void setRain(String rain) {
        mRain = rain;
    }

    public String getRainProbability() {
        return mRainProbability;
    }

    public void setRainProbability(String rainProbability) {
        mRainProbability = rainProbability;
    }

    public String getSolarRadiation() {
        return mSolarRadiation;
    }

    public void setSolarRadiation(String solarRadiation) {
        mSolarRadiation = solarRadiation;
    }

    public String getTemperature() {
        return mTemperature;
    }

    public void setTemperature(String temperature) {
        mTemperature = temperature;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        mTime = time;
    }

    public String getTotalCloudCover() {
        return mTotalCloudCover;
    }

    public void setTotalCloudCover(String totalCloudCover) {
        mTotalCloudCover = totalCloudCover;
    }

    public String getWindDirection() {
        return mWindDirection;
    }

    public void setWindDirection(String windDirection) {
        mWindDirection = windDirection;
    }

    public String getWindGust() {
        return mWindGust;
    }

    public void setWindGust(String windGust) {
        mWindGust = windGust;
    }

    public String getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        mWindSpeed = windSpeed;
    }

}
