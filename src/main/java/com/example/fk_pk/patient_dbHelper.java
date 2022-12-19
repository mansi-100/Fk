package com.example.fk_pk;


import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

public  class patient_dbHelper  extends SQLiteOpenHelper {

    public patient_dbHelper(Context context) {
        super(context, "pk.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
        db.execSQL("create table Register_patient (Name TEXT not null,Email TEXT not null,Contact_No TEXT primary key not null ,Address TEXT not null,Password TEXT not null)");

        db.execSQL("create table chat (name TEXT,pass TEXT,doc_no TEXT,FOREIGN KEY(doc_no) REFERENCES Register_patient (Contact_No))");

        //CONSTRAINT fk_Register_patient
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Register_patient");

        db.execSQL("drop table if exists chat");

    }


    public boolean register(String name,String Email,String Phone,String add,String pass)
    {

        SQLiteDatabase sql=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("Name",name);
        contentValues.put("Email",Email);
        contentValues.put("Contact_No",Phone);
        contentValues.put("Address",add);
        contentValues.put("Password",pass);
//https://youtu.be/j63_E-BOs_A
        long r=sql.insert("Register_patient",null,contentValues);
        if(r==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getdata (String Email, String Password)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Register_patient where Email=? and Password=?",new String[]{Email,Password});
        return cursor;
    }
    public boolean register(String name,String pass,String i)
    {
        SQLiteDatabase sql=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("pass",pass);
        contentValues.put("doc_no",i);

        long r=sql.insert("chat",null,contentValues);
        if(r==-1)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }
}
