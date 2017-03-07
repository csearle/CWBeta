package com.cannawellness.chris.cwbeta;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Questionaire2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire2);

        Spinner sp = (Spinner)findViewById(R.id.spinner);
        Spinner sp2 = (Spinner)findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.relationship_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(adapter);
        sp.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
        sp2.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
    }

}
