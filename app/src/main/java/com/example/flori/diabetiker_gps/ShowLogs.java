package com.example.flori.diabetiker_gps;

import android.app.ActionBar;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowLogs extends AppCompatActivity {

    ArrayList<Positions> listOfLogs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_show_logs);
        listOfLogs = new ArrayList<>();
        loadData();
    }

    private void loadData() {
        DataBaseHelper dbHelper = new DataBaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor rows = db.rawQuery(PositionsTbl.STMT_SELECT_ALL,new String[]{});
        while(rows.moveToNext()){
            listOfLogs.add(new Positions(rows.getString(0),rows.getString(1),rows.getString(2),rows.getString(3)));
        }
        rows.close();
        db.close();
        ListView listView = (ListView) findViewById(R.id.loglist);
        ArrayAdapter<Positions> adapter = new ArrayAdapter<Positions>(this,android.R.layout.simple_list_item_1,listOfLogs);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
