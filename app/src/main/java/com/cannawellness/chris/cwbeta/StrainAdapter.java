package com.cannawellness.chris.cwbeta;

import android.content.Intent;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chris on 7/20/2016.
 */

public class StrainAdapter extends RecyclerView.Adapter<StrainAdapter.StrainViewHolder> {

    private List<Strain> strainList;
    public Context context;
    public StrainAdapter(List<Strain> strainList, Context mcontext){
        this.strainList = strainList;
        this.context = mcontext;
    }


    @Override
    public int getItemCount(){
        return strainList.size();
    }

    @Override
    public void onBindViewHolder(StrainViewHolder strainViewHolder, int i) {
        Strain s = strainList.get(i);
        strainViewHolder.vName.setText(s.getLPName());
        strainViewHolder.vTHC.setText(String.valueOf(s.getTHC()));
        strainViewHolder.vType.setText(s.getType());
        strainViewHolder.vCBD.setText(String.valueOf(s.getCBD()));
    }

    @Override
    public StrainViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.strain_card_view, viewGroup, false);

        return new StrainViewHolder(itemView, context);
    }

    public static class StrainViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vTHC;
        protected TextView vType;
        protected TextView vCBD;

        public StrainViewHolder(View v, final Context con){
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("CardView", (String)vName.getText());
                    Intent i = new Intent(con, Modality.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    con.startActivity(i);
                }
            });
            vName = (TextView)v.findViewById(R.id.name);
            vTHC = (TextView)v.findViewById(R.id.txtTHC);
            vType = (TextView)v.findViewById(R.id.txtType);
            vCBD = (TextView)v.findViewById(R.id.txtCBD);
        }
    }
}
