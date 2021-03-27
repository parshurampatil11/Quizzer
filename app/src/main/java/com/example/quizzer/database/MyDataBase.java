package com.example.quizzer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "qiuze.db";
    private Context context;
    private final static int DATABASE_VERSION = 1;

    public final static String TABLE_NAME = "quizTable";

    public final static String COLUMN_ID = "_id";
    public final static String COLUMN_NAME = "name";
    public final static String COLUMN_EMAIL = "email";
    public final static String COLUMN_PASSWORD = "password";
    public final static String COLUMN_USERNAME = "username";


    public MyDataBase(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_QUERY = " CREATE TABLE "+ TABLE_NAME +" ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_EMAIL + " TEXT NOT NULL, "
                + COLUMN_USERNAME + " TEXT NOT NULL, "
                + COLUMN_PASSWORD + " TEXT NOT NULL); ";

        db.execSQL(SQL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_Q = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(SQL_Q);
    }

    public void insertData(String name, String email, String userName, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL,email);
        values.put(COLUMN_USERNAME,userName);
        values.put(COLUMN_PASSWORD,password);

        long newRow = db.insert(TABLE_NAME,null,values);
        if(newRow==-1){
            Toast.makeText(context,"Insert Failed",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context,"Insert Successfully",Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor displayData(){

        String query = "SELECT * FROM " +TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
