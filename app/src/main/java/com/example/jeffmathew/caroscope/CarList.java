package com.example.jeffmathew.caroscope;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jeffmathew.caroscope.Database.DataBaseHelper;
import com.example.jeffmathew.caroscope.adaptor.ListCarAdaptor;
import com.example.jeffmathew.caroscope.model.car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class CarList extends AppCompatActivity {

    private ListView lvProduct;
    private ListCarAdaptor adapter;
    private List<car> mProductList;
    private DataBaseHelper mDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_car_list);
        lvProduct = (ListView)findViewById(R.id.listview_cars);
        mDBHelper = new DataBaseHelper(this);

        //Check exists database
        File database = getApplicationContext().getDatabasePath(DataBaseHelper.DBNAME);
        if(false == database.exists()) {
            mDBHelper.getReadableDatabase();
            //Copy db
            if(copyDatabase(this)) {
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        //Get product list in db when db exists
        mProductList = mDBHelper.getListProduct();
        //Init adapter
        adapter = new ListCarAdaptor(this, mProductList);
        //Set adapter for listview
        lvProduct.setAdapter(adapter);

    }




    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(DataBaseHelper.DBNAME);
            String outFileName = DataBaseHelper.DBLOCATION + DataBaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity", "DB copied");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
