//package com.dietkeeper.app.db;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//
//import com.dietkeeper.app.model.Food;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Elrol on 2016/10/16.
// */
//public class DBServer {
//        private DKOpenHelper dbhelper;
//        public DBServer(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
//        {
//            this.dbhelper = new DKOpenHelper(context,name,factory,version);
//        }
//
//    /**
//    public List<Food> findFoodByfoodName(String classId)
//    {
//        List<Food> localArrayList=new ArrayList<Food>();
//        SQLiteDatabase localSQLiteDatabase = this.dbhelper.getWritableDatabase();
//        Cursor localCursor = localSQLiteDatabase.rawQuery("select *  from Food  " +
//                "where fat=10  order by foodCalories desc", new String[]{classId});
//
//        while (localCursor.moveToNext())
//        {
//            Food temp=new Food();
//            temp.setId(localCursor.getInt(localCursor.getColumnIndex("id")));
//            temp.setFoodName(localCursor.getString(localCursor.getColumnIndex("foodName")));
//            temp.setCarbohydrate(localCursor.getInt(localCursor.getColumnIndex("carbohydrate")));
//            temp.setFat(localCursor.getInt(localCursor.getColumnIndex("fat")));
//            temp.setFoodCalories(localCursor.getInt(localCursor.getColumnIndex("foodCalories")));
//            temp.setProtein(localCursor.getInt(localCursor.getColumnIndex("protein")));
//            temp.setTraceElements(localCursor.getInt(localCursor.getColumnIndex("traceElements")));
//            temp.setFoodAvoid(localCursor.getString(localCursor.getColumnIndex("foodAvoid")));
//            localArrayList.add(temp);
//        }
//        localSQLiteDatabase.close();
//        return localArrayList;
//    }
//     **/
//
//    /**
//     * 查找所有食物
//     *
//     */
//    public List<Food> findAllFood()
//    {
//        List<Food> localArrayList=new ArrayList<Food>();
//        SQLiteDatabase localSQLiteDatabase = this.dbhelper.getWritableDatabase();
//        Cursor localCursor = localSQLiteDatabase.rawQuery("select * from Food " +
//                "where 1=1  order by fat desc ", null);
//        while (localCursor.moveToNext())
//        {
//            Food temp=new Food();
//            temp.setId(localCursor.getInt(localCursor.getColumnIndex("id")));
//            temp.setFoodName(localCursor.getString(localCursor.getColumnIndex("foodName")));
//            temp.setCarbohydrate(localCursor.getInt(localCursor.getColumnIndex("carbohydrate")));
//            temp.setFat(localCursor.getInt(localCursor.getColumnIndex("fat")));
//            localArrayList.add(temp);
//        }
//        localSQLiteDatabase.close();
//        return localArrayList;
//    }
//
//    /**
//     * 查找是否有该食物
//     *
//     */
//    public boolean isStudentsExists(String foodId)
//    {
//        SQLiteDatabase localSQLiteDatabase = this.dbhelper.getWritableDatabase();
//        Cursor localCursor = localSQLiteDatabase.rawQuery("select count(*)  from Food  " +
//                "where id=?", new String[]{foodId});
//        localCursor.moveToFirst();
//        if(localCursor.getLong(0)>0)
//            return true;
//        else
//            return false;
//    }
//
//}
