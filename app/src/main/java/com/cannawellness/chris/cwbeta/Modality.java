package com.cannawellness.chris.cwbeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Modality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modality);

        Button btn_smoke = (Button)findViewById(R.id.btn_option_smoke);
        Button btn_vape = (Button)findViewById(R.id.btn_option_vaporize);
        Button btn_oil = (Button)findViewById(R.id.btn_option_oral);

        btn_smoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Smoke.class);
                startActivity(i);
            }
        });
        btn_vape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Vape.class);
                startActivity(i);
            }
        });
        btn_oil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Oil.class);
                startActivity(i);
            }
        });
    }
}
