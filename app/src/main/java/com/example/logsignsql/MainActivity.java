package com.example.logsignsql;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    public static class databasehelper extends SQLiteOpenHelper {

        public static final String databaseName = "SignLog.db";

        public databasehelper(@Nullable Context context) {
            super(context, "SignLog.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase MyDatabase) {
            MyDatabase.execSQL("create Table users(email TEXT primary key, password TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
            MyDB.execSQL("drop Table if exists users");
        }

        public Boolean insertData(String email, String password){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("email", email);
            contentValues.put("password", password);
            long result = MyDatabase.insert("users", null, contentValues);

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }

        public Boolean checkEmail(String email){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ?", new String[]{email});

            if(cursor.getCount() > 0) {
                return true;
            }else {
                return false;
            }
        }
        public Boolean checkEmailPassword(String email, String password){
            SQLiteDatabase MyDatabase = this.getWritableDatabase();
            Cursor cursor = MyDatabase.rawQuery("Select * from users where email = ? and password = ?", new String[]{email, password});

            if (cursor.getCount() > 0) {
                return true;
            }else {
                return false;
            }
        }
    }
}
