package com.example.satya.mysqliteex1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by satya on 12/28/2016.
 */
//step 2:create a dabase java file separately which act as CONTROLLER
public class MyDataBase {
    //step 5: declaire vrequired variables
    MyHelper myHelper ;
    SQLiteDatabase sqLiteDatabase ;//for doing DML operation
    //step 6: create object for MyHelper variable by taking an constructor
    public  MyDataBase(Context c)
    {
        myHelper = new MyHelper(c,"techpalle.db",null,1);

    }
    //step7 :create sqlitedatabase object
    public void open()
    {
        sqLiteDatabase = myHelper.getWritableDatabase();
    }
    //step 8: perform DML operartion
    public void insertStudent(String name, String course)
    {
        ContentValues cv= new ContentValues();
        cv.put("sname",name);
        cv.put("scourse",course);
        sqLiteDatabase.insert("student",null,cv);//here inserting rows

    }
    //keep update and delete() on hold
    public Cursor queryStudent()
    {
        Cursor c= null;
        c = sqLiteDatabase.query("student",null,null,null,null,null,null,null);
        return  c;
    }
    //step 9 : close data base
    public void close()
    {
        sqLiteDatabase.close();
    }
    //Step3: create Inner Healper class for DDL operation
    private class MyHelper extends SQLiteOpenHelper {
        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            //Step 4: create all required tables in this method
            //during creating sql command you have to also give semicolon inside doublecort
            db.execSQL("create table student(_id integer primary key, sname text, scourse text);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
