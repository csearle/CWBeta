package com.cannawellness.chris.cwbeta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

public class StrainChooser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strain_chooser);

        DBHelper db = new DBHelper(this);

        //Inserting Strains/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addStrain(new Strain(1,"Luminarium", "Delahaze", 12.5, .8, 17.5, 0.0, 1, "Sativa", "CannaFarms"));
        db.addStrain(new Strain(2,"Odin", "SourDiesel", 8, .65, 19.0, 0.0, 3, "Sativa", "Aurora"));
        db.addStrain(new Strain(3,"Sedamin", "Pink Kush", 12.5, .30, 24.5, 0.0, 1, "Indica", "MedRelief"));
        db.addStrain(new Strain(1,"Luminarium", "Delahaze", 12.5, .8, 17.5, 0.0, 1, "Sativa", "Aurora"));
        db.addStrain(new Strain(2,"Odin", "SourDiesel", 8, .65, 19.0, 0.0, 3, "Sativa", "Aurora"));
        db.addStrain(new Strain(3,"Sedamin", "Pink Kush", 12.5, .30, 24.5, 0.0, 1, "Indica", "CannaFarms"));
        db.addStrain(new Strain(1,"Luminarium", "Delahaze", 12.5, .8, 17.5, 0.0, 1, "Sativa", "MedRelief"));
        db.addStrain(new Strain(2,"Odin", "SourDiesel", 8, .65, 19.0, 0.0, 3, "Sativa", "MedRelief"));
        db.addStrain(new Strain(3,"Sedamin", "Pink Kush", 12.5, .30, 24.5, 0.0, 1, "Indica", "CannaFarms"));
        db.addStrain(new Strain(4,"Sinafw", "foianfowi", 12, .20, 24.0, 0.0, 2, "Hybrid", "Aurora"));
        db.addStrain(new Strain(4, "Blah", "blah blah", 4, .20, 23.0, 0.1, 3, "Hybrid", "CannaFarms"));
        db.addStrain(new Strain(5, "idk", "sourdiesel", 8, .40, 30.0, 0.0, 3,"Sativa", "Aurora"));
        //Reading all strains
        Log.d("Reading: ", "Reading all strains..");
        List<Strain> strains = db.getAllStrains();
        String[] str_strains = new String[db.getStrainsCount()];
        int i=0;

        for(Strain strain: strains) {
            String log = "Id: " + strain.getId() + " ,Name: " + strain.getName() + " ,Type: " + strain.getType();
            str_strains[i] = log;
            if(i<=str_strains.length){i++;}
            //Writing strains to log
            Log.d("Strain: : ", log);
        }

        //RecyclerView / cards
        RecyclerView strainsList = (RecyclerView)findViewById(R.id.cardList);
        strainsList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        strainsList.setLayoutManager(llm);
        StrainAdapter sa = new StrainAdapter(strains, getApplicationContext());
        strainsList.setAdapter(sa);

        //Spinner with LP names
        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"MedReleaf", "CannaFarms", "Aurora"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_list_text_view, items);
        adapter.setDropDownViewResource(R.layout.custom_list_text_view);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
