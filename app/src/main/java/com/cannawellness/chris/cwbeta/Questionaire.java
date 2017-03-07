package com.cannawellness.chris.cwbeta;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Questionaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionaire);

        //Initialise Spinners
        Spinner spQ1 = (Spinner)findViewById(R.id.spinner);
        Spinner spQ2 = (Spinner)findViewById(R.id.spinnerQ2);
        Spinner spQ4 = (Spinner)findViewById(R.id.spinnerQ4);

        //Initialize adapters
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.relationship_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.children_number_array, android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.allergytest_number_array, android.R.layout.simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //set spinner adapters
        spQ1.setAdapter(adapter);
        spQ2.setAdapter(adapter2);
        spQ4.setAdapter(adapter4);

        spQ1.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
        spQ2.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
        spQ4.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);

        spQ1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView)parent.getChildAt(0)).setTextSize(22);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spQ2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView)parent.getChildAt(0)).setTextSize(22);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spQ4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView)parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView)parent.getChildAt(0)).setTextSize(22);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button btn_date = (Button)findViewById(R.id.dateButton);
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        Button btn_next = (Button)findViewById(R.id.nextButton);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Questionaire2.class);
                startActivity(i);
            }
        });
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
