package com.example.contact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="ContactDB";
    public static final int DB_VERSION=1;
    public static final String ID="ID";
    public static final String Name="Name";
    public static final String PhoneNumber="PhoneNumber";
    public static final String TableName="Contact";


    public ContactDBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableSql="create table "+ TableName+" ( "
                +ID+" text primary key ,"
                +Name+" text not null,"
                +PhoneNumber+" text not null )";
        sqLiteDatabase.execSQL(createTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropTableSql="Drop table if exists "+TableName;
        sqLiteDatabase.execSQL(dropTableSql);
        onCreate(sqLiteDatabase);
    }
}
