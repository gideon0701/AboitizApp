package com.pentagon.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
import com.mapbox.mapboxsdk.style.layers.LineLayer;
import com.mapbox.mapboxsdk.style.layers.Property;
import com.mapbox.mapboxsdk.style.layers.PropertyFactory;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.mapboxsdk.style.sources.Source;
import com.mapbox.mapboxsdk.style.sources.VectorSource;

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
import static com.mapbox.mapboxsdk.style.expressions.Expression.interpolate;
import static com.mapbox.mapboxsdk.style.expressions.Expression.literal;
import static com.mapbox.mapboxsdk.style.expressions.Expression.stop;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleBlur;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.circleRadius;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillColor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.fillOpacity;


public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;

    private MapView mapView;
    private FillLayer layer;

    public static final String ID_ADD_SOURCE = "gidopogi";
    public static final String ID_SOURCE = "map-74t6d7";
    public static final String ID_LAYER = "Coast-Line";

    private List<Point> routeCoordinates;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Mapbox Access token
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        drawGeo();
        setContentView(R.layout.activity_main);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<StationsModel> call = apiInterface.getAllStations();
        call.enqueue(new Callback<StationsModel>() {
            @Override
            public void onResponse(Call<StationsModel> call, Response<StationsModel> response) {
                StationsModel test = response.body();
                Log.d("adad", "adadsa");

            }

            @Override
            public void onFailure(Call<StationsModel> call, Throwable t) {
                Log.d("adada", "adasdas");
            }
        });


        mapView = (MapView) findViewById(R.id.mapView);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                // Customize map with markers, polylines, etc.
                try {
                    URL geoJsonUrl = new URL("https://gist.githubusercontent.com/carlodizon03/d0864f2506a98104180b838cbfbca355/raw/5947887b78d03f57174f2f50d0a44f796640f506/geoawdwadwad.geojson");
                    GeoJsonSource urbanAreasSource = new GeoJsonSource("urban-areas", geoJsonUrl);
                    mapboxMap.addSource(urbanAreasSource);

                    CircleLayer urbanArea = new CircleLayer("urban-areas-fill", "urban-areas");

                    urbanArea.setProperties(
                            circleRadius(10f),
                            circleColor(Color.parseColor("#d10000")),
                            circleBlur(0.6f)
                    );

                    mapboxMap.addLayerBelow(urbanArea, "water");
                } catch (MalformedURLException malformedUrlException) {
                    malformedUrlException.printStackTrace();
                }
            }
        });

    }
    private void drawGeo(){
        routeCoordinates = new ArrayList<Point>();
        routeCoordinates.add(Point.fromLngLat(-118.39439114221236, 33.397676454651766));
        routeCoordinates.add(Point.fromLngLat(-118.39421054012902, 33.39769799454838));
        routeCoordinates.add(Point.fromLngLat(-118.39408583869053, 33.39761901490136));
        routeCoordinates.add(Point.fromLngLat(-118.39388373635917, 33.397328225582285));
        routeCoordinates.add(Point.fromLngLat(-118.39372033447427, 33.39728514560042));
        routeCoordinates.add(Point.fromLngLat(-118.3930882271826, 33.39756875508861));
        routeCoordinates.add(Point.fromLngLat(-118.3928216241072, 33.39759029501192));
        routeCoordinates.add(Point.fromLngLat(-118.39227981785722, 33.397234885594564));
        routeCoordinates.add(Point.fromLngLat(-118.392021814881, 33.397005125197666));
        routeCoordinates.add(Point.fromLngLat(-118.39090810203379, 33.396814854409186));
        routeCoordinates.add(Point.fromLngLat(-118.39040499623022, 33.39696563506828));
        routeCoordinates.add(Point.fromLngLat(-118.39005669221234, 33.39703025527067));
        routeCoordinates.add(Point.fromLngLat(-118.38953208616074, 33.39691896489222));
        routeCoordinates.add(Point.fromLngLat(-118.38906338075398, 33.39695127501678));
        routeCoordinates.add(Point.fromLngLat(-118.38891287901787, 33.39686511465794));
        routeCoordinates.add(Point.fromLngLat(-118.38898167981154, 33.39671074380141));
        routeCoordinates.add(Point.fromLngLat(-118.38984598978178, 33.396064537239404));
        routeCoordinates.add(Point.fromLngLat(-118.38983738968255, 33.39582400356976));
        routeCoordinates.add(Point.fromLngLat(-118.38955358640874, 33.3955978295119));
        routeCoordinates.add(Point.fromLngLat(-118.389041880506, 33.39578092284221));
        routeCoordinates.add(Point.fromLngLat(-118.38872797688494, 33.3957916930261));
        routeCoordinates.add(Point.fromLngLat(-118.38817327048618, 33.39561218978703));
        routeCoordinates.add(Point.fromLngLat(-118.3872530598711, 33.3956265500598));
        routeCoordinates.add(Point.fromLngLat(-118.38653065153775, 33.39592811523983));
        routeCoordinates.add(Point.fromLngLat(-118.38638444985126, 33.39590657490452));
        routeCoordinates.add(Point.fromLngLat(-118.38638874990086, 33.395737842093304));
        routeCoordinates.add(Point.fromLngLat(-118.38723155962309, 33.395027006653244));
        routeCoordinates.add(Point.fromLngLat(-118.38734766096238, 33.394441819579285));
        routeCoordinates.add(Point.fromLngLat(-118.38785936686516, 33.39403972556368));
        routeCoordinates.add(Point.fromLngLat(-118.3880743693453, 33.393616088784825));
        routeCoordinates.add(Point.fromLngLat(-118.38791956755958, 33.39331092541894));
        routeCoordinates.add(Point.fromLngLat(-118.3874852625497, 33.39333964672257));
        routeCoordinates.add(Point.fromLngLat(-118.38686605540683, 33.39387816940854));
        routeCoordinates.add(Point.fromLngLat(-118.38607484627983, 33.39396792286514));
        routeCoordinates.add(Point.fromLngLat(-118.38519763616081, 33.39346171215717));
        routeCoordinates.add(Point.fromLngLat(-118.38523203655761, 33.393196040109466));
        routeCoordinates.add(Point.fromLngLat(-118.3849955338295, 33.393023711860515));
        routeCoordinates.add(Point.fromLngLat(-118.38355931726203, 33.39339708930139));
        routeCoordinates.add(Point.fromLngLat(-118.38323251349217, 33.39305243325907));
        routeCoordinates.add(Point.fromLngLat(-118.3832583137898, 33.39244928189641));
        routeCoordinates.add(Point.fromLngLat(-118.3848751324406, 33.39108499551671));
        routeCoordinates.add(Point.fromLngLat(-118.38522773650804, 33.38926830725471));
        routeCoordinates.add(Point.fromLngLat(-118.38508153482152, 33.38916777794189));
        routeCoordinates.add(Point.fromLngLat(-118.38390332123025, 33.39012280171983));
        routeCoordinates.add(Point.fromLngLat(-118.38318091289693, 33.38941192035707));
        routeCoordinates.add(Point.fromLngLat(-118.38271650753981, 33.3896129783018));
        routeCoordinates.add(Point.fromLngLat(-118.38275090793661, 33.38902416443619));
        routeCoordinates.add(Point.fromLngLat(-118.38226930238106, 33.3889451769069));
        routeCoordinates.add(Point.fromLngLat(-118.38258750605169, 33.388420985121336));
        routeCoordinates.add(Point.fromLngLat(-118.38177049662707, 33.388083490107284));
        routeCoordinates.add(Point.fromLngLat(-118.38080728551597, 33.38836353925403));
        routeCoordinates.add(Point.fromLngLat(-118.37928506795642, 33.38717870977523));
        routeCoordinates.add(Point.fromLngLat(-118.37898406448423, 33.3873079646849));
        routeCoordinates.add(Point.fromLngLat(-118.37935386875012, 33.38816247841951));
        routeCoordinates.add(Point.fromLngLat(-118.37794345248027, 33.387810620840135));
        routeCoordinates.add(Point.fromLngLat(-118.37546662390886, 33.38847843095069));
        routeCoordinates.add(Point.fromLngLat(-118.37091717142867, 33.39114243958559));
    }
    private void addRadar(MapboxMap mapboxMap) {
        VectorSource vectorSource = new VectorSource(
                ID_SOURCE,
                "mapbox://styles/carlodp003/cjnz0c8m81pic2rm211w2575x"
        );
        mapboxMap.addSource(vectorSource);
        layer = mapboxMap.getLayerAs(ID_LAYER);
        if (layer == null) {
            layer = new FillLayer(ID_LAYER, ID_SOURCE);
            layer.withSourceLayer("201806261518");
            layer.setFilter(eq((get("idx")), literal(0)));
            layer.setProperties(PropertyFactory.visibility(String.valueOf(VISIBLE)),
                    fillColor(interpolate(Expression.exponential(1f),
                            get("value"),
                            stop(8, Expression.rgb(20, 160, 240)),
                            stop(18, Expression.rgb(20, 190, 240)),
                            stop(36, Expression.rgb(20, 220, 240)),
                            stop(54, Expression.rgb(20, 250, 240)),
                            stop(72, Expression.rgb(20, 250, 160)),
                            stop(90, Expression.rgb(135, 250, 80)),
                            stop(108, Expression.rgb(250, 250, 0)),
                            stop(126, Expression.rgb(250, 180, 0)),
                            stop(144, Expression.rgb(250, 110, 0)),
                            stop(162, Expression.rgb(250, 40, 0)),
                            stop(180, Expression.rgb(180, 40, 40)),
                            stop(198, Expression.rgb(110, 40, 80)),
                            stop(216, Expression.rgb(80, 40, 110)),
                            stop(234, Expression.rgb(50, 40, 140)),
                            stop(252, Expression.rgb(20, 40, 170))
                            )
                    ),
                    fillOpacity(0.7f));
            mapboxMap.addLayer(layer);
        }
    }
}
