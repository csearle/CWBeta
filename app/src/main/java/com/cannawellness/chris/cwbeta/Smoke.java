package com.cannawellness.chris.cwbeta;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.content.Intent;
import android.widget.NumberPicker;

public class Smoke extends AppCompatActivity {

    static Dialog d ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke);


        Button btn_joint = (Button) findViewById(R.id.btn_option_joint);
        Button btn_bowl = (Button) findViewById(R.id.btn_option_bowl);

        btn_bowl.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                showBowl();
            }
        });
        btn_joint.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                showJoint();
            }
        });

    }

    public void showBowl()
    {

        final Dialog d = new Dialog(Smoke.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.d_smoke_bowl_weight);
        d.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        // Making the dialogs a certain size (.8f, .5f)

        Activity activity = this;
        Rect displayRectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.d_smoke_bowl_weight, null);
        layout.setMinimumWidth((int)(displayRectangle.width() * 0.8f));
        layout.setMinimumHeight((int)(displayRectangle.height() * 0.5f));
        d.setContentView(layout);
        //

        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(100);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Effects.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });

        d.show();


    }

    public void showJoint()
    {



        final Dialog d = new Dialog(Smoke.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.d_smoke_joint_size);
        d.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        // Making the dialogs a certain size (.8f, .5f)

//Floating Point Numberpicker



        final Activity activity = this;
        final Rect displayRectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        final LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View layout = inflater.inflate(R.layout.d_smoke_joint_size, null);
        layout.setMinimumWidth((int)(displayRectangle.width() * 0.8f));
        layout.setMinimumHeight((int)(displayRectangle.height() * 0.5f));
        d.setContentView(layout);

        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);

                String nums[]= {"0.1","0.2","0.3","0.4","0.5","0.6","0.7","0.8","0.9","1.0","1.1","1.2","1.3","1.4","1.5","1.6","1.7","1.8","1.9","2.0","2.1","2.2"};

                np.setMinValue(1);
                np.setMaxValue(nums.length);
                np.setValue(6);
                np.setDisplayedValues(null);
                np.setWrapSelectorWheel(false);
                np.setDisplayedValues(nums);




        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.setContentView(R.layout.d_smoke_joint_size2);
                View layout2 = inflater.inflate(R.layout.d_smoke_joint_size2,null);
                layout2.setMinimumWidth((int)(displayRectangle.width() * 0.8f));
                layout2.setMinimumHeight((int)(displayRectangle.height() * 0.5f));
                d.setContentView(layout2);
                Button btn_full = (Button)layout2.findViewById(R.id.buttonFull);
                Button btn_partial = (Button)layout2.findViewById(R.id.buttonPartial);

                btn_full.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(),Effects.class);
                        startActivity(i);
                    }
                });

                btn_partial.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(),Partial.class);
                        startActivity(i);
                    }
                });
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();
    }
}
