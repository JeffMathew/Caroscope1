package com.example.jeffmathew.caroscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);


    }

    public void sendMessage2(View view)
    {
        Spinner mySpinner = (Spinner) findViewById(R.id.Spinner);
        String text = mySpinner.getSelectedItem().toString();

        Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
        String text1 = mySpinner1.getSelectedItem().toString();

        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);
        String text2 = mySpinner2.getSelectedItem().toString();

        Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner3);
        String text3 = mySpinner3.getSelectedItem().toString();

        Spinner mySpinner4 = (Spinner) findViewById(R.id.spinner4);
        String text4 = mySpinner4.getSelectedItem().toString();



       // TextView textout = (TextView) findViewById(R.id.textView);
        //textout.setText(text);

        Bundle bundle = new Bundle();
        bundle.putString("type",text);
        bundle.putString("company",text1);
        bundle.putString("price",text2);
        bundle.putString("transmission",text3);
        bundle.putString("fuel",text4);


        Intent intent = new Intent(FilterActivity.this, CarList.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
