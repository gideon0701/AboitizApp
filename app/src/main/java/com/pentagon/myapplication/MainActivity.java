package com.pentagon.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.CircleLayer;
import com.mapbox.mapboxsdk.style.layers.FillLayer;
import com.mapbox.mapboxsdk.style.layers.HeatmapLayer;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.style.sources.VectorSource;
import com.pentagon.myapplication.StationModel.Result;
import com.pentagon.myapplication.StationModel.StationsModel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.VISIBLE;
import static com.mapbox.mapboxsdk.style.expressions.Expression.eq;
import static com.mapbox.mapboxsdk.style.expressions.Expression.get;
import static com.mapbox.mapboxsdk.style.expressions.Expression.heatmapDensity;
import static com.mapbox.mapboxsdk.style.expressions.Expression.interpolate;
import static com.mapbox.mapboxsdk.style.expressions.Expression.linear;
import static com.mapbox.mapboxsdk.style.expressions.Expression.literal;
import static com.mapbox.mapboxsdk.style.expressions.Expression.rgb;
import static com.mapbox.mapboxsdk.style.expressions.Expression.rgba;
import static com.mapbox.mapboxsdk.style.expressions.Expression.stop;
import static com.mapbox.mapboxsdk.style.expressions.Expression.switchCase;
import static com.mapbox.mapboxsdk.style.expressions.Expression.zoom;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleBlur;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleRadius;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillOpacity;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.heatmapColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.heatmapIntensity;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.heatmapOpacity;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.heatmapRadius;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.heatmapWeight;


public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;

    private MapView mapView;

    private List<Point> routeCoordinates;
    private List<Point> drizzleCoordinates;
    private List<Point> lightRainCoordinates;
    private List<Point> moderateRainCoordinates;
    private List<Point> heavyRainCoordinates;
    private List<Point> extremeRainCoordinates;

    private StationsModel stationsModel;
    private MapboxMap mMapboxMap;
    private LineString lineString;
    private FeatureCollection featureCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mapbox Access token
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));

        List<Point> drizzleCoordinates = new ArrayList<Point>();
        List<Point> lightRainCoordinates = new ArrayList<Point>();
        List<Point> moderateRainCoordinates = new ArrayList<Point>();
        List<Point> heavyRainCoordinates = new ArrayList<Point>();
        List<Point> extremeRainCoordinates = new ArrayList<Point>();

        setContentView(R.layout.activity_main);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        mapView = (MapView) findViewById(R.id.mapView);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                mMapboxMap = mapboxMap;

                Call<StationsModel> call = apiInterface.getAllStations();
                call.enqueue(new Callback<StationsModel>() {
                    @Override
                    public void onResponse(Call<StationsModel> call, Response<StationsModel> response) {
                        StationsModel stationsModel = response.body();
                        Log.d("adad", "adadsa");
                        for (Result res : stationsModel.getResults()) {
                            double longitude = res.getStation().getLon();
                            double latitude = res.getStation().getLat();

                            if (res.getRain() > 0 && res.getRain() < 1 ) {
                                drizzleCoordinates.add(Point.fromLngLat(longitude, latitude));
                            }else if (res.getRain() >= 1 && res.getRain() < 5) {
                                lightRainCoordinates.add(Point.fromLngLat(longitude, latitude));
                            }else if (res.getRain() >= 5 && res.getRain() < 10) {
                                moderateRainCoordinates.add(Point.fromLngLat(longitude, latitude));
                            }else if (res.getRain() >= 10 && res.getRain() < 20) {
                                heavyRainCoordinates.add(Point.fromLngLat(longitude, latitude));
                            }else if (res.getRain() >= 20) {
                                extremeRainCoordinates.add(Point.fromLngLat(longitude, latitude));
                            }
                        }
                        lineString = LineString.fromLngLats(drizzleCoordinates);
                        featureCollection = FeatureCollection.fromFeatures(
                                new Feature[]{Feature.fromGeometry(lineString)});
                        GeoJsonSource geoJsonDrizzle = new GeoJsonSource("geojson-drizzleSource", featureCollection);
                        mMapboxMap.addSource(geoJsonDrizzle);
                        addHeatmapLayer("drizzleLayer","geojson-drizzleSource", 1);

                        lineString = LineString.fromLngLats(lightRainCoordinates);
                        featureCollection = FeatureCollection.fromFeatures(
                                new Feature[]{Feature.fromGeometry(lineString)});
                        GeoJsonSource geoJsonLight = new GeoJsonSource("geojson-lightSource", featureCollection);
                        mMapboxMap.addSource(geoJsonLight);
                        addHeatmapLayer("lightLayer","geojson-lightSource", 2);

                        lineString = LineString.fromLngLats(moderateRainCoordinates);
                        featureCollection = FeatureCollection.fromFeatures(
                                new Feature[]{Feature.fromGeometry(lineString)});
                        GeoJsonSource geoJsonModerate = new GeoJsonSource("geojson-moderateSource", featureCollection);
                        mMapboxMap.addSource(geoJsonModerate);
                        addHeatmapLayer("moderateLayer","geojson-moderateSource", 3);

                        lineString = LineString.fromLngLats(heavyRainCoordinates);
                        featureCollection = FeatureCollection.fromFeatures(
                                new Feature[]{Feature.fromGeometry(lineString)});
                        GeoJsonSource geoJsonHeavy = new GeoJsonSource("geojson-heavySource", featureCollection);
                        mMapboxMap.addSource(geoJsonHeavy);
                        addHeatmapLayer("heavyLayer","geojson-heavySource", 4);

                        lineString = LineString.fromLngLats(extremeRainCoordinates);
                        featureCollection = FeatureCollection.fromFeatures(
                                new Feature[]{Feature.fromGeometry(lineString)});
                        GeoJsonSource geoJsonExtreme = new GeoJsonSource("geojson-extremeSource", featureCollection);
                        mMapboxMap.addSource(geoJsonExtreme);
                        addHeatmapLayer("extremeLayer","geojson-extremeSource", 5);

                    }

                    @Override
                    public void onFailure(Call<StationsModel> call, Throwable t) {
                        Log.d("adada", "adasdas");
                        Toast.makeText(MainActivity.this,"API Error",Toast.LENGTH_LONG);
                    }
                });

            }
        });

    }
    /**
     * For the heatmap layer
     * @param layerID
     * @param sourceID
     */
    private void addHeatmapLayer(String layerID, String sourceID, int intensity) {
        Expression style0 = null;
        Expression style1 = null;
        HeatmapLayer layer = new HeatmapLayer(layerID, sourceID);
        switch (intensity) {
            case 1: //drizzle
                style0 =rgb(228, 232, 74);
                style1 = rgb(231, 236, 22);
                break;
            case 2: //light
                style0 =rgb(237, 191, 54);
                style1 = rgb(236, 182, 22);
                break;

            case 3: //Moderate
                style0 =rgb(242, 146, 46);
                style1 = rgb(236, 132, 22);
                break;

            case 4: //Heavy
                style0 =rgb(242, 128, 72);
                style1 = rgb(236, 93, 22);
                break;

            case 5: //Heavy
                style0 = rgb(242, 62, 62);
                style1 =rgb(236, 22, 22);
                break;
        }

        layer.setMaxZoom(9);
        layer.setSourceLayer(sourceID);
        layer.setProperties(

                // Color ramp for heatmap.  Domain is 0 (low) to 1 (high).
                // Begin color ramp at 0-stop with a 0-transparancy color
                // to create a blur-like effect.
                heatmapColor(
                        interpolate(
                                linear(), heatmapDensity(),
                                literal(0), rgba(33, 102, 172, 0),
                                literal(0.2), rgb(103, 169, 207),
                                literal(0.4), rgb(209, 229, 240),
                                literal(0.6), rgb(209, 229, 240),
                                literal(0.8), style0,
                                literal(1), style1
                        )
                ),

                // Increase the heatmap weight based on frequency and property magnitude
                heatmapWeight(
                        interpolate(
                                linear(), get("mag"),
                                stop(0, 0),
                                stop(6, 1)
                        )
                ),

                // Increase the heatmap color weight weight by zoom level
                // heatmap-intensity is a multiplier on top of heatmap-weight
                heatmapIntensity(
                        interpolate(
                                linear(), zoom(),
                                stop(0, 1),
                                stop(9, 3)
                        )
                ),

                // Adjust the heatmap radius by zoom level
                heatmapRadius(
                        interpolate(
                                linear(), zoom(),
                                stop(0, 2),
                                stop(9, 20)
                        )
                ),

                // Transition from heatmap to circle layer by zoom level
                heatmapOpacity(
                        interpolate(
                                linear(), zoom(),
                                stop(7, 1),
                                stop(9, 0)
                        )
                )
        );

        mMapboxMap.addLayerAbove(layer, "waterway-label");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
