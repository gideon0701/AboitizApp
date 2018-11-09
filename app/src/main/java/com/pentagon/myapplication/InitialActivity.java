package com.pentagon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialActivity extends AppCompatActivity {
    Button btnCalcRisk;
    Button btnViewMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);
        btnCalcRisk  = (findViewById(R.id.btnCalcRisk));
        btnViewMap = (findViewById(R.id.btnViewMap));

        btnViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InitialActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnCalcRisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(InitialActivity.this, RiskCalcActivity.class);
                startActivity(i);
            }
        });
    }
}
