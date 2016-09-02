package com.example.jeffmathew.caroscope.adaptor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        TextView carCompany = (TextView)v.findViewById(R.id.car_company);
        carName.setText(mCarList.get(i).getName());
        carCompany.setText(mCarList.get(i).getCompany());


        return v;
    }
}
