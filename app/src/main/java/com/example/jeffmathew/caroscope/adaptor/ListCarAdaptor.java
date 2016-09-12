package com.example.jeffmathew.caroscope.adaptor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeffmathew.caroscope.CarList;
import com.example.jeffmathew.caroscope.DetailsActivity;
import com.example.jeffmathew.caroscope.R;
import com.example.jeffmathew.caroscope.model.car;



import java.util.List;

/**
 * Created by Jeff Mathew on 28-08-2016.
 */
public class ListCarAdaptor extends BaseAdapter {
    private Context mContext;
    private List<car> mCarList;

    public ListCarAdaptor(Context mContext, List<car> mCarList) {
        this.mContext = mContext;
        this.mCarList = mCarList;
    }

    @Override
    public int getCount() {
        return mCarList.size();
    }

    @Override
    public Object getItem(int i) {
        return mCarList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mCarList.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view.inflate(mContext, R.layout.item_listview, null);
        TextView carName = (TextView) v.findViewById(R.id.car_name);
        TextView carCompany = (TextView) v.findViewById(R.id.car_company);
        carName.setText(mCarList.get(i).getName());
        carCompany.setText(mCarList.get(i).getCompany());


        return v;
    }


   /* @Override
    public View getView(int position, View convertView, ViewGroup parent, final Context mContext) {
        View row = convertView;
        Holder holder = null;
        if (row  == null) {
            LayoutInflater vi =
                    (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = vi.inflate(R.layout.item_listview, null);
            holder.txtTitle1 = (TextView) row.findViewById(R.id.car_name);
            holder.txtTitle2 = (TextView) row.findViewById(R.id.car_company);
            holder.txtTitle1.setText(mCarList.get(position).getName());
            holder.txtTitle2.setText(mCarList.get(position).getCompany());


            holder.txtTitle1 .setOnClickListener(new View.OnClickListener() {



                public void onClick(View v) {

                    TextView tv = (TextView)v.findViewById(R.id.car_name);
                    String name = tv.getText().toString();


                }
            });

            holder.txtTitle2 .setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                }
            });
        }
        return row;
    }
/////
///////////

    static class Holder {
        TextView txtTitle1;
        TextView txtTitle2;
    } */








}


