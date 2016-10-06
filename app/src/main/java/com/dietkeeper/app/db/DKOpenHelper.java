package com.dietkeeper.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Elrol on 2016/10/6.
 */
public class DKOpenHelper extends SQLiteOpenHelper{
    /**
     * User表建表语句
     */
    public static final String CREAT_USER="creat table User("
            +"id integer primary key autoincrement,"
            +"user_name text,"
            +"user_calories integer,"
            +"user_food text,"
            +"user_breakfast text,"
            +"user_lunch text,"
            +"user_dinner text,)";

    /**
     * Food表建表语句
     */
    public static final String CREAT_FOOD="creat table Food("
            +"id integer primary key autoincrement,"
            +"food_name text,"
            +"food_calories integer,"
            +"protein integer,"
            +"fat integer,"
            +"carbohydrate integer,"
            +"trace elements integer,"
            +"food_avoid text,)";

    /**
     * News表建表语句
     */
    public static final String CREAT_NEWS="creat table News("
            +"id integer primary key autoincrement,"
            +"news_name text,"
            +"news_content text,)";


    public DKOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_USER);
        db.execSQL(CREAT_FOOD);
        db.execSQL(CREAT_NEWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
