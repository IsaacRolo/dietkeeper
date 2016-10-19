package com.dietkeeper.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.dietkeeper.app.db.DKOpenHelper;


public class MainActivity extends AppCompatActivity{
    private DKOpenHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper=new DKOpenHelper(this,"DietKeeper.db",null,1);
        Button createDatabase=(Button) findViewById(R.id.create_db);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbhelper.getWritableDatabase();
            }
        });
        Button addData=(Button)findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("id","1");
                values.put("food_name","egg");
                values.put("food_calories","1");
                values.put("protein","1");
                values.put("fat","1");
                values.put("carbohydrate","1");
                values.put("trace_elements","1");
                db.insert("Food",null,values);
                values.clear();
                values.put("id","2");
                values.put("food_name","pork");
                values.put("food_calories","1");
                values.put("protein","1");
                values.put("fat","1");
                values.put("carbohydrate","1");
                values.put("trace_elements","1");
                db.insert("Food",null,values);
            }
        });
        Button queryButton=(Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                Cursor cursor=db.query("Food",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        int id=cursor.getInt(cursor.getColumnIndex("id"));
                        String food_Name=cursor.getString(cursor.getColumnIndex("food_name"));
                        int food_Calories=cursor.getInt(cursor.getColumnIndex("food_calories"));
                        int fat=cursor.getInt(cursor.getColumnIndex("fat"));
                        int carbohydrate=cursor.getInt(cursor.getColumnIndex("carbohydrate"));
                        int trace_Elements=cursor.getInt(cursor.getColumnIndex("trace_elements"));
                        Log.d("MainActivity","id is "+id);
                        Log.d("MainActivity","name is "+food_Name);
                        Log.d("MainActivity","cll is "+food_Calories);
                        Log.d("MainActivity","zf is "+fat);
                        Log.d("MainActivity","tshhw is "+carbohydrate);
                        Log.d("MainActivity","wlys is "+trace_Elements);
                    }while(cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }

}
