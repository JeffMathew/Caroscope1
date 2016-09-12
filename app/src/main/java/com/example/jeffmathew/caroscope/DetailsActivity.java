package com.example.jeffmathew.caroscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String company = bundle.getString("company");

        TextView nameContent = (TextView)findViewById(R.id.textView3);
        nameContent.setText(name);

        TextView companyContent = (TextView)findViewById(R.id.textView4);
        companyContent.setText(company);
    }
}
