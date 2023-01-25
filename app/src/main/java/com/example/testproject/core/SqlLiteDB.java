package com.example.testproject.core;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

public class SqlLiteDB {

    public  static SQLiteDatabase getDB(){
        return SQLiteDatabase.openDatabase(Environment.getExternalStorageDirectory() +
                "/login/mydbtest.db", null ,SQLiteDatabase.NO_LOCALIZED_COLLATORS
                | SQLiteDatabase.OPEN_READWRITE);
    }
}
