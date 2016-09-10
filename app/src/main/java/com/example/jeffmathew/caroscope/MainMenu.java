package com.example.jeffmathew.caroscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
    public void sendMessage(View view)
    {
        Intent intent = new Intent(MainMenu.this, FilterActivity.class);
        startActivity(intent);
    }

    public void sendMessage1(View view)
    {
        Intent intent = new Intent(MainMenu.this, TestActivity.class);
        startActivity(intent);
    }
}
