package com.example.jeffmathew.caroscope.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jeffmathew.caroscope.model.car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeff Mathew on 02-09-2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "car_name.db";
    public static final String DBLOCATION = "/data/data/com.example.jeffmathew.caroscope/databases/" ;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DataBaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public List<car> getListProduct() {
        car car = null;
        List<car> productList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM car_info", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            car = new car(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            productList.add(car);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return productList;
    }
}
