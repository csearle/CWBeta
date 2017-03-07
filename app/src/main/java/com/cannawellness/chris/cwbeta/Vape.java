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

public class Vape extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);

        final Dialog d = new CustomDialog(this);
        d.setTitle("Custom");
        d.setContentView(R.layout.custom_dialog_layout);

        Activity activity = this;
        Rect displayRectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.d_vape_method, null);
        layout.setMinimumWidth((int)(displayRectangle.width() * 0.8f));
        layout.setMinimumHeight((int)(displayRectangle.height() * 0.5f));
        d.setContentView(layout);


        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPickerPartial);

        String nums[]= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"};

        np.setMinValue(1);
        np.setMaxValue(nums.length);
        np.setValue(6);
        np.setDisplayedValues(null);
        np.setWrapSelectorWheel(false);
        np.setDisplayedValues(nums);

        d.show();

        Button b1 = (Button)d.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), VapeWeight.class);
                startActivity(i);
            }
        });
    }
}
