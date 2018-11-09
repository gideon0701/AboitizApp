
package com.pentagon.myapplication.StationModel;


import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("dewpoint")
    private Double mDewpoint;
    @SerializedName("heat_index")
    private Double mHeatIndex;
    @SerializedName("mean_sea_level_pressure")
    private Double mMeanSeaLevelPressure;
    @SerializedName("rain")
    private Double mRain;
    @SerializedName("rain_probability")
    private Double mRainProbability;
    @SerializedName("solar_radiation")
    private Double mSolarRadiation;
    @SerializedName("station")
    private Station mStation;
    @SerializedName("temperature")
    private Double mTemperature;
    @SerializedName("timestamp")
    private String mTimestamp;
    @SerializedName("total_cloud_cover")
    private Double mTotalCloudCover;
    @SerializedName("wind_direction")
    private Double mWindDirection;
    @SerializedName("wind_gust")
    private Double mWindGust;
    @SerializedName("wind_speed")
    private Double mWindSpeed;

    public Double getDewpoint() {
        return mDewpoint;
    }

    public void setDewpoint(Double dewpoint) {
        mDewpoint = dewpoint;
    }

    public Double getHeatIndex() {
        return mHeatIndex;
    }

    public void setHeatIndex(Double heatIndex) {
        mHeatIndex = heatIndex;
    }

    public Double getMeanSeaLevelPressure() {
        return mMeanSeaLevelPressure;
    }

    public void setMeanSeaLevelPressure(Double meanSeaLevelPressure) {
        mMeanSeaLevelPressure = meanSeaLevelPressure;
    }

    public Double getRain() {
        return mRain;
    }

    public void setRain(Double rain) {
        mRain = rain;
    }

    public Double getRainProbability() {
        return mRainProbability;
    }

    public void setRainProbability(Double rainProbability) {
        mRainProbability = rainProbability;
    }

    public Double getSolarRadiation() {
        return mSolarRadiation;
    }

    public void setSolarRadiation(Double solarRadiation) {
        mSolarRadiation = solarRadiation;
    }

    public Station getStation() {
        return mStation;
    }

    public void setStation(Station station) {
        mStation = station;
    }

    public Double getTemperature() {
        return mTemperature;
    }

    public void setTemperature(Double temperature) {
        mTemperature = temperature;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

    public Double getTotalCloudCover() {
        return mTotalCloudCover;
    }

    public void setTotalCloudCover(Double totalCloudCover) {
        mTotalCloudCover = totalCloudCover;
    }

    public Double getWindDirection() {
        return mWindDirection;
    }

    public void setWindDirection(Double windDirection) {
        mWindDirection = windDirection;
    }

    public Double getWindGust() {
        return mWindGust;
    }

    public void setWindGust(Double windGust) {
        mWindGust = windGust;
    }

    public Double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        mWindSpeed = windSpeed;
    }

}
