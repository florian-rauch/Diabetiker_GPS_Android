package com.example.flori.diabetiker_gps;

/**
 * Created by flori on 27.01.2017.
 */

public class PositionsTbl {
    public static final String TABLE_NAME="Positions";

    public static final String Longitude="Longitude";
    public static final String Latitude="Latitude";
    public static final String MyDate="MyDate";
    public static final String Time="Time";

    public static final String[] ALL_COLUMNS=new String[]{Longitude,Latitude,MyDate,Time};
    public static final String SQL_DROP="DROP TABLE IF EXISTS "+ TABLE_NAME;
    public static final String SQL_CREATE="CREATE TABLE "+TABLE_NAME+"("+
            Longitude+" TEXT NOT NULL, "+
            Latitude+" TEXT NOT NULL, "+
            MyDate+" TEXT NOT NULL, "+
            Time+" TEXT NOT NULL)";
    public static final String STMT_DELETE="DELETE FROM "+TABLE_NAME;
    public static final String STMT_INSERT="INSERT INTO "+TABLE_NAME+
            "( "+Longitude+", "+Latitude+", "+MyDate+ ", "+Time+") VALUES(?,?,?,?)";

    public static final String STMT_SELECT_ALL="SELECT "+Longitude+","+Latitude+","+MyDate+","+Time+" FROM "+TABLE_NAME;



}
