package com.cannawellness.chris.cwbeta;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Partial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke_partial);

        Dialog d = new CustomDialog(this);
        d.setTitle("Custom");
        d.setContentView(R.layout.custom_dialog_layout);

        Activity activity = this;
        Rect displayRectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.d_smoke_joint_partial, null);
        layout.setMinimumWidth((int)(displayRectangle.width() * 0.8f));
        layout.setMinimumHeight((int)(displayRectangle.height() * 0.5f));
        d.setContentView(layout);

        final NumberPicker np = (NumberPicker)d.findViewById(R.id.numberPicker1);


        final String nums[]= {"1/16","2/16","3/16","4/16","5/16","6/16","7/16","8/16","9/16","10/16","11/16","12/16","13/16","14/16","15/16","1"};
        final String nums2[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        np.setMinValue(1);
        np.setMaxValue(nums2.length);
        np.setValue(6);
        np.setDisplayedValues(null);
        np.setWrapSelectorWheel(false);
        np.setDisplayedValues(nums2);

        RadioGroup rg = (RadioGroup)d.findViewById(R.id.radioGroup1);
        final TextView tv = (TextView)d.findViewById(R.id.textView5);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId==R.id.radioAndroid) {
                    np.setDisplayedValues(null);
                    np.setMaxValue(nums2.length);
                    np.setDisplayedValues(nums2);
                    tv.setText("Select Number of Inhalations");
                }else{
                    np.setDisplayedValues(null);
                    np.setMaxValue(nums.length);
                    np.setDisplayedValues(nums);
                    tv.setText("Select Joint Portion Size");
                }
            }
        });

        Button b1 = (Button)d.findViewById(R.id.button1);
        Button b2 = (Button)d.findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Effects.class);
                startActivity(i);
            }
        });

        d.show();
    }
}
