package com.example.sqlitinkotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQliteHelperClass(contextt:Context):SQLiteOpenHelper(contextt, DATABASE_NAME,null,1) {

    companion object {
        const val DATABASE_NAME = "student.db"
        const val TABLE_NAME = "student_table"
        const val ID = "ID"
        const val NAME = "NAME"
        const val SURNAME = "SURNAME"
        const val MARKS = "MARKS"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("create table $TABLE_NAME(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertvalues(name: String, surname: String, marks: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, name)
        contentValues.put(SURNAME, surname)
        contentValues.put(MARKS, marks)
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result > 0
    }

    fun getalldata() : Cursor{
        val db = this.writableDatabase
        return db.rawQuery("select * from $TABLE_NAME ", null)
    }
fun updatedata(id :String,name:String,surname:String,marks:String):Boolean{
    var db = this.writableDatabase
    val contentvalue  = ContentValues()
    contentvalue.put(ID,id)
    contentvalue.put(NAME,name)
    contentvalue.put(SURNAME,surname)
    contentvalue.put(MARKS,marks)
   var result = db.update(TABLE_NAME,contentvalue," ID = ?", arrayOf(id))
    return result >0
}

    fun deletedata(id:String):Boolean
    {
        val db = this.writableDatabase
       var res = db.delete(TABLE_NAME,"ID = ?", arrayOf(id))
        return res>0
    }
}