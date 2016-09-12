package com.example.jeffmathew.caroscope;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jeffmathew.caroscope.Database.DataBaseHelper;
import com.example.jeffmathew.caroscope.adaptor.ListCarAdaptor;
import com.example.jeffmathew.caroscope.model.car;

import org.w3c.dom.Text;

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

        Bundle bundle = getIntent().getExtras();
        String type = bundle.getString("type");
        String company = bundle.getString("company");
        String price = bundle.getString("price");
        String transmission = bundle.getString("transmission");
        String fuel = bundle.getString("fuel");

        //TextView typeContent = (TextView)findViewById(R.id.textView3);
        //typeContent.setText(type);

        //TextView companyContent = (TextView) findViewById(R.id.textView4);
        //companyContent.setText(company);

        //TextView priceContent = (TextView) findViewById(R.id.textView5);
        //priceContent.setText(price);


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


       /* lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id)
            {

               Object o = lvProduct.getItemAtPosition(position);
                String stuff = o.toString();
                Toast.makeText(getApplicationContext(), stuff, Toast.LENGTH_LONG).show();


                //String value = (String)adapter.getItemAtPosition(position);

                //Intent intent = new Intent(CarList.this, TestActivity.class);
                //startActivity(intent);

                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
            }
        }); */









        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                                    long id)
            {

                TextView tv = (TextView) v.findViewById(R.id.car_name);
                TextView tv1 = (TextView) v.findViewById(R.id.car_company);
                String name = tv.getText().toString();
                String company = tv1.getText().toString();
                Toast.makeText(CarList.this,name +" " + company,Toast.LENGTH_SHORT).show();

                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("company",company);

                Intent intent = new Intent(CarList.this,DetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);

                //String value = (String)adapter.getItemAtPosition(position);

                //Intent intent = new Intent(CarList.this, TestActivity.class);
                //startActivity(intent);

                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row
            }
        });
    }

   /* public void sendMessage10(View view)
    {
        TextView myTv = (TextView)findViewById(R.id.car_name);
        String text = myTv.getText().toString();
        TextView myTv1 = (TextView)findViewById(R.id.car_company);
        String text1 = myTv1.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("name",text);
        bundle.putString("company",text1);

        Intent intent = new Intent(CarList.this,DetailsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    } */






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
