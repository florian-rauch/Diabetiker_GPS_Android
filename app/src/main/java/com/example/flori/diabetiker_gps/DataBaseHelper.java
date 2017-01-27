package com.example.flori.diabetiker_gps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by resch on 27.01.2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "person.db";
    private final static int DB_VERSION = 1;
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PositionsTbl.SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PositionsTbl.SQL_DROP);
        onCreate(db);
    }
}
