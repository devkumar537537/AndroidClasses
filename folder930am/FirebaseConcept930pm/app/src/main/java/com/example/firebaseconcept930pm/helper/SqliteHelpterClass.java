package com.example.firebaseconcept930pm.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteHelpterClass extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String ID = "ID";
    public static final String TITLE= "TITLE";
    public static final String DATE = "DATE";
    public static final String BODY = "BODY";

    public SqliteHelpterClass(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,DATE TEXT,BODY INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertdata(String name,String surname,String marks)
    {
        SQLiteDatabase sql = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TITLE,name);
        contentValues.put(DATE,surname);
        contentValues.put(BODY,marks);

        long result = sql.insert(TABLE_NAME,null,contentValues);
        if(result == -1) {
            return false;
        }else
        {
            return true;
        }
    }
    public  boolean updatadata(String id,String name,String surname,String marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(TITLE,name);
        contentValues.put(DATE,surname);
        contentValues.put(BODY,marks);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});

        return true;

    }
    public Cursor getalldata()
    {
        SQLiteDatabase sql = this.getWritableDatabase();
      Cursor cursor = sql.rawQuery("select * from "+TABLE_NAME ,null);
//        Cursor cursor = sql.rawQuery("select * from "+TABLE_NAME +" where "+NAME + " = ?",new String[]{"lul"});
        return cursor;
    }

    public Integer deletedata(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,"ID = ?",new String[]{id});
    }
}
