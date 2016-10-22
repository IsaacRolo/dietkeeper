package com.dietkeeper.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.dietkeeper.app.db.DKOpenHelper;
import com.dietkeeper.app.model.Food;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{
    private DKOpenHelper dbhelper;
    private ArrayList<Food> foodlist;
    private ListView lv;
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
                values.put("food_name","鸡蛋");
                values.put("food_calories","1");
                values.put("protein","1");
                values.put("fat","1");
                values.put("carbohydrate","1");
                values.put("trace_elements","1");
                db.insert("Food",null,values);
                values.clear();
                values.put("food_name","牛肉");
                values.put("food_calories","1");
                values.put("protein","1");
                values.put("fat","1");
                values.put("carbohydrate","1");
                values.put("trace_elements","1");
                db.insert("Food",null,values);
                values.clear();
                values.put("food_name","猪肉");
                values.put("food_calories","1");
                values.put("protein","1");
                values.put("fat","1");
                values.put("carbohydrate","1");
                values.put("trace_elements","1");
                db.insert("Food",null,values);
                values.clear();
                values.put("food_name","牛奶");
                values.put("food_calories","1");
                values.put("protein","1");
                values.put("fat","1");
                values.put("carbohydrate","1");
                values.put("trace_elements","1");
                db.insert("Food",null,values);
                values.clear();

                values.put("food_name","馒头");
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
                foodlist=new ArrayList<>();             //实例化foodlist，否则空指针异常，泛型
                Cursor cursor=db.query("Food",null,null,null,null,null,null);
                if(cursor.moveToFirst()){
                    do{
                        int id=cursor.getInt(cursor.getColumnIndex("id"));
                        String food_Name=cursor.getString(cursor.getColumnIndex("food_name"));
                        int food_Calories=cursor.getInt(cursor.getColumnIndex("food_calories"));
                        int protein=cursor.getInt(cursor.getColumnIndex("protein"));
                        int fat=cursor.getInt(cursor.getColumnIndex("fat"));
                        int carbohydrate=cursor.getInt(cursor.getColumnIndex("carbohydrate"));
                        int trace_Elements=cursor.getInt(cursor.getColumnIndex("trace_elements"));
                        Food fd = new Food(id,food_Name,food_Calories,protein,fat,carbohydrate,trace_Elements);
                        foodlist.add(fd);

                    }while(cursor.moveToNext());
                }
                cursor.close();
                lv=(ListView) findViewById(R.id.food_lv);
                lv.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return foodlist.size();
                    }

                    @Override
                    public Object getItem(int position) {
                        return null;
                    }

                    @Override
                    public long getItemId(int position) {
                        return 0;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                            View view;
                            //对ListView的优化，convertView为空时，创建一个新视图；convertView不为空时，代表它是滚出
                            //屏幕，放入Recycler中的视图,若需要用到其他layout，则用inflate(),同一视图，用fiindViewBy()
                            if(convertView==null){
                                view = View.inflate(getBaseContext(),R.layout.foodlayout,null);
                            }
                            else{
                                view = convertView;
                            }

                            //从list中取出一行数据，position相当于数组下标,可以实现逐行取数据
                            Food fd = foodlist.get(position);
                            TextView id = (TextView)view.findViewById(R.id.food_id);
                            TextView name = (TextView)view.findViewById(R.id.food_name);
                            TextView cal = (TextView)view.findViewById(R.id.food_calories);
                            TextView fat = (TextView)view.findViewById(R.id.fat);
                            TextView car = (TextView)view.findViewById(R.id.carbohydrate);
                            TextView pr= (TextView)view.findViewById(R.id.protein);
                            TextView tr = (TextView)view.findViewById(R.id.trace_elements);
                            id.setText(Integer.toString(fd.getId()));
                            name.setText(fd.getFoodName());
                            cal.setText(Integer.toString(fd.getFoodCalories()));
                            fat.setText(Integer.toString(fd.getFat()));
                            car.setText(Integer.toString(fd.getCarbohydrate()));
                            pr.setText(Integer.toString(fd.getProtein()));
                            tr.setText(Integer.toString(fd.getTraceElements()));
                            return view;
                        }

                });
            }
        });



        Button queryButton2=(Button) findViewById(R.id.query_data2);
        queryButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db=dbhelper.getWritableDatabase();
                foodlist=new ArrayList<>();             //实例化foodlist，否则空指针异常，泛型
                Cursor cursor=db.rawQuery("select * from Food where food_name=?",new String[]{"牛肉"});
                if(cursor.moveToFirst()){
                    do{
                        int id=cursor.getInt(cursor.getColumnIndex("id"));
                        String food_Name=cursor.getString(cursor.getColumnIndex("food_name"));
                        int food_Calories=cursor.getInt(cursor.getColumnIndex("food_calories"));
                        int protein=cursor.getInt(cursor.getColumnIndex("protein"));
                        int fat=cursor.getInt(cursor.getColumnIndex("fat"));
                        int carbohydrate=cursor.getInt(cursor.getColumnIndex("carbohydrate"));
                        int trace_Elements=cursor.getInt(cursor.getColumnIndex("trace_elements"));
                        Food fd = new Food(id,food_Name,food_Calories,protein,fat,carbohydrate,trace_Elements);
                        foodlist.add(fd);

                    }while(cursor.moveToNext());
                }
                cursor.close();
                lv=(ListView) findViewById(R.id.food_lv);
                lv.setAdapter(new BaseAdapter() {
                    @Override
                    public int getCount() {
                        return foodlist.size();
                    }

                    @Override
                    public Object getItem(int position) {
                        return null;
                    }

                    @Override
                    public long getItemId(int position) {
                        return 0;
                    }

                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view;
                        //对ListView的优化，convertView为空时，创建一个新视图；convertView不为空时，代表它是滚出
                        //屏幕，放入Recycler中的视图,若需要用到其他layout，则用inflate(),同一视图，用fiindViewBy()
                        if(convertView==null){
                            view = View.inflate(getBaseContext(),R.layout.foodlayout,null);
                        }
                        else{
                            view = convertView;
                        }

                        //从list中取出一行数据，position相当于数组下标,可以实现逐行取数据
                        Food fd = foodlist.get(position);
                        TextView id = (TextView)view.findViewById(R.id.food_id);
                        TextView name = (TextView)view.findViewById(R.id.food_name);
                        TextView cal = (TextView)view.findViewById(R.id.food_calories);
                        TextView fat = (TextView)view.findViewById(R.id.fat);
                        TextView car = (TextView)view.findViewById(R.id.carbohydrate);
                        TextView pr= (TextView)view.findViewById(R.id.protein);
                        TextView tr = (TextView)view.findViewById(R.id.trace_elements);
                        id.setText(Integer.toString(fd.getId()));
                        name.setText(fd.getFoodName());
                        cal.setText(Integer.toString(fd.getFoodCalories()));
                        fat.setText(Integer.toString(fd.getFat()));
                        car.setText(Integer.toString(fd.getCarbohydrate()));
                        pr.setText(Integer.toString(fd.getProtein()));
                        tr.setText(Integer.toString(fd.getTraceElements()));
                        return view;
                    }

                });
            }
        });

    }

}
