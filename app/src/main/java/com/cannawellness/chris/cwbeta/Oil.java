package com.cannawellness.chris.cwbeta;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Oil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);

        Button btn_caps = (Button) findViewById(R.id.btn_option_caps);
        Button btn_syringe = (Button) findViewById(R.id.btn_option_Syringe);
        Button btn_concentrate = (Button) findViewById(R.id.btn_option_concentrate);

        final Dialog d = new CustomDialog(this);
        d.setTitle("Custom");
        d.setContentView(R.layout.custom_dialog_layout);

        Activity activity = this;
        Rect displayRectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.d_oil_syringe_weight, null);
        layout.setMinimumWidth((int)(displayRectangle.width() * 0.8f));
        layout.setMinimumHeight((int)(displayRectangle.height() * 0.5f));
        d.setContentView(layout);


        btn_caps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.show();
                final NumberPicker np = (NumberPicker)d.findViewById(R.id.numberPicker1);
                final String nums2[]= {"1","2","3","4","5","6","7","8","9","10"};
                np.setMinValue(1);
                np.setMaxValue(nums2.length);
                np.setValue(3);
                np.setDisplayedValues(null);
                np.setWrapSelectorWheel(false);
                np.setDisplayedValues(nums2);

                final TextView tv = (TextView)d.findViewById(R.id.textView2);
                tv.setText("Select Number of Capsules");

                Button next = (Button)d.findViewById(R.id.button1);
                next.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        if(tv.getText()=="Capsule Size"){
                            Intent i = new Intent(getApplicationContext(),OilPotency.class);
                            startActivity(i);
                        }else {
                            final String nums3[] = {"00", "0", "1", "2", "3", "4"};
                            np.setMinValue(1);
                            np.setMaxValue(nums3.length);
                            np.setValue(0);
                            np.setDisplayedValues(null);
                            np.setWrapSelectorWheel(false);
                            np.setDisplayedValues(nums3);

                            tv.setText("Capsule Size");
                        }
                    }
                });
            }
        });

        btn_syringe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.show();
                NumberPicker np = (NumberPicker)d.findViewById(R.id.numberPicker1);
                final String nums2[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
                np.setMinValue(1);
                np.setMaxValue(nums2.length);
                np.setValue(3);
                np.setDisplayedValues(null);
                np.setWrapSelectorWheel(false);
                np.setDisplayedValues(nums2);

                TextView tv = (TextView)d.findViewById(R.id.textView2);
                tv.setText("Select Volume (ml)");

                Button next = (Button)d.findViewById(R.id.button1);
                next.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), OilPotency.class);
                        startActivity(i);
                    }
                });

            }
        });

        btn_concentrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.show();
                NumberPicker np = (NumberPicker)d.findViewById(R.id.numberPickerPartial);
                final String nums2[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
                np.setMinValue(1);
                np.setMaxValue(nums2.length);
                np.setValue(3);
                np.setDisplayedValues(null);
                np.setWrapSelectorWheel(false);
                np.setDisplayedValues(nums2);

                TextView tv = (TextView)d.findViewById(R.id.textView2);
                tv.setText("Select Volume (mg)");

                Button next = (Button)d.findViewById(R.id.button1);
                next.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), Effects.class);
                        startActivity(i);
                    }
                });
            }
        });
    }
}
