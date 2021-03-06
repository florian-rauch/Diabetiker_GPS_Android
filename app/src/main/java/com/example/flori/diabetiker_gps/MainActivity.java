package com.example.flori.diabetiker_gps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private static LocationManager locMan = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        locMan = (LocationManager) getSystemService(LOCATION_SERVICE);


        ((Button) findViewById(R.id.button_anzeigen)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAnzeigenbtnclicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
    }

    private void onAnzeigenbtnclicked() {
        Intent intent = new Intent(this,ShowLogs.class);
        startActivity(intent);
    }


    @Override
    public void onLocationChanged(Location location) {
        if(location!=null){
            double la = location.getLatitude();
            double lo = location.getLongitude();
            Date d = new Date();

            Positions p=new Positions(
                    String.format("%.4f",lo),
                    String.format("%.4f",la),
                    android.text.format.DateFormat.format("DD.MM.YYYY",d.getTime()).toString(),
                    android.text.format.DateFormat.format("HH:mm",d.getTime()).toString());
            ((EditText)findViewById(R.id.editText_position)).setText(p.toString());
            DataBaseHelper dbHelper = new DataBaseHelper(this);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL(PositionsTbl.STMT_INSERT,new String[]{p.longitude,p.latitude,p.date,p.time});
            db.close();
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {}

    @Override
    public void onProviderEnabled(String s) {}

    @Override
    public void onProviderDisabled(String s) {}
}
