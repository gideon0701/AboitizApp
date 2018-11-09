package com.pentagon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.pentagon.myapplication.IndividualDataModel.IndividualDataModel;
import com.pentagon.myapplication.IndividualDataModel.Result;
import com.pentagon.myapplication.StationModel.StationsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiskCalcActivity extends AppCompatActivity {
    APIInterface apiInterface;

    TextView textViewHeatIndex;
    TextView textViewRainProb;
    TextView textViewCloudCov;
    TextView textViewWindSpeed;
    TextView textViewWindDir;
    TextView textViewWindGust;
    TextView textViewTemp;
    TextView textViewRain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_calc);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        textViewHeatIndex = findViewById(R.id.textViewHeatIndex);
        textViewRainProb = findViewById(R.id.textViewRainProb);
        textViewCloudCov = findViewById(R.id.textViewCloudCover);
        textViewWindSpeed = findViewById(R.id.textViewWindSpeed);
        textViewWindDir = findViewById(R.id.textViewWindDir);
        textViewWindGust = findViewById(R.id.textViewWindGust);
        textViewTemp = findViewById(R.id.textViewTemp);
        textViewRain = findViewById(R.id.textViewRain);

        Call<IndividualDataModel> call = apiInterface.getStation("14.326320,120.936012");
        call.enqueue(new Callback<IndividualDataModel>() {
            @Override
            public void onResponse(Call<IndividualDataModel> call, Response<IndividualDataModel> response) {
                IndividualDataModel model = response.body();
                double totalHeatIndex = 0;
                double totalRainProb = 0;
                double totalCloudCov = 0;
                double totalWindSpeed = 0;
                double totalWindDir = 0;
                double totalWindGust = 0;
                double totalTemp = 0;
                double totalRain = 0;

                double average = 0;
                for (Result result: model.getResults()) {
                    totalHeatIndex += result.getHeatIndex();
                    totalRainProb += result.getRainProbability();
                    totalCloudCov += result.getTotalCloudCover();
                    totalWindSpeed += result.getWindSpeed();
                    totalWindDir += result.getWindDirection();
                    totalWindGust +=  result.getWindGust();
                    totalTemp += result.getTemperature();
                    totalRain += result.getRain();
                }
                average = Math.round(totalHeatIndex / model.getResults().size());
                textViewHeatIndex.setText("" + average);

                average = Math.round(totalRainProb / model.getResults().size());
                textViewRainProb.setText("" + average);

                average = Math.round(totalCloudCov / model.getResults().size());
                textViewCloudCov.setText("" + average);

                average = Math.round(totalWindSpeed / model.getResults().size());
                textViewWindSpeed.setText("" + average);

                average = Math.round(totalWindDir / model.getResults().size());
                textViewWindDir.setText("" + average);

                average = Math.round(totalWindGust / model.getResults().size());
                textViewWindGust.setText("" + average);

                average = Math.round(totalTemp / model.getResults().size());
                textViewTemp.setText("" + average);

                average = Math.round(totalRain / model.getResults().size());
                textViewRain.setText("" + average);
            }

            @Override
            public void onFailure(Call<IndividualDataModel> call, Throwable t) {
                Toast.makeText(RiskCalcActivity.this,"API Error",Toast.LENGTH_LONG);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
