package com.example.user.myapplication.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 8/2/2017.
 */

public class DataMonAn extends SQLiteOpenHelper {

    public static final String DB_MonAn = "MonAn";
    public static final String TB_Mon = "MON";
    public static final String CL_TENMON = "tenmon";
    public static final String CL_kalo = "kalo";
    public static final String CL_id = "_id";

    public DataMonAn(Context context) {
        super(context, DB_MonAn, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MON(_id INTEGER PRIMARY KEY AUTOINCREMENT, tenmon TEXT, kalo INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS MON");
        onCreate(db);
    }
}
