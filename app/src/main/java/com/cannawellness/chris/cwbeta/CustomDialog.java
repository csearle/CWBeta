package com.cannawellness.chris.cwbeta;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

/**
 * Created by chris on 11/14/2016.
 */
public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context);
        setTitle("My First Custom Tabbed Dialog");
        setContentView(R.layout.custom_dialog_layout);

        // get our tabHost from the xml
        TabHost tabHost = (TabHost)findViewById(R.id.TabHost01);
        tabHost.setup();

        // create tab 1
        TabHost.TabSpec spec1 = tabHost.newTabSpec("tab1");
        spec1.setIndicator("Profile", context.getResources().getDrawable(R.drawable.roundedbuttongrey));
        spec1.setContent(R.id.TextView01);
        tabHost.addTab(spec1);
        //create tab2
        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2");
        spec2.setIndicator("Profile", context.getResources().getDrawable(R.drawable.roundedbuttongrey));
        spec2.setContent(R.id.TextView02);
        tabHost.addTab(spec2);

    }
}
