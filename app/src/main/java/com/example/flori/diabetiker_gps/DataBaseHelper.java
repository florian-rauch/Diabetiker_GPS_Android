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
        db.execSQL(PositionsTbl.STMT_INSERT,new String[]{""+38,""+122,"19.11.2016","06:42"});
        db.execSQL(PositionsTbl.STMT_INSERT,new String[]{""+55,""+545,"19.11.2017","07:42"});
        db.execSQL(PositionsTbl.STMT_INSERT,new String[]{""+45353783.535,""+7,"19.13.2026","08:42"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PositionsTbl.SQL_DROP);
        onCreate(db);
    }
}
