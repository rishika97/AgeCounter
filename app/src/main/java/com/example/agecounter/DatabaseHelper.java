package com.example.agecounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static String databaseName="Details.db";

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists emp( Name varchar(15),Email varchar(20),ENo integer(10),Password varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean insertData(String[] data) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",data[0]);
        values.put("Email",data[1]);
        values.put("ENo",data[2]);
        values.put("Password",data[3]);

        Long result=db.insert("emp", null, values);
        if(result==-1)
        {
            return false;
        }
        return true;
    }

    public Cursor showData()
    {
        SQLiteDatabase s = this.getReadableDatabase();
        String query = "select * from emp";
        Cursor res = s.rawQuery(query,null);
        return res;
    }
    public Boolean getData(String uname, String passw)
    {
        SQLiteDatabase s = this.getReadableDatabase();
        String query = "select * from emp where Name='"+uname+"' and Password='"+passw+"'";
        Cursor res2=s.rawQuery(query,null);
        if(res2.getCount()<1)
        {
            return false;
        }
        return true;
    }

}
