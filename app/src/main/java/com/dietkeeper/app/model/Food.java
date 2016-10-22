package com.dietkeeper.app.model;

/**
 * Created by Elrol on 2016/10/6.
 */
public class Food {
    private int id;
    private String foodName;
    private int foodCalories;
    private int protein;
    private int fat;
    private int carbohydrate;
    private int traceElements;
    private Food[] foodAvoid;

    public Food( int id,String foodName,int foodCalories, int protein, int fat,int carbohydrate,  int traceElements) {
        this.carbohydrate = carbohydrate;
        this.id = id;
        this.foodName = foodName;
        this.foodCalories = foodCalories;
        this.protein = protein;
        this.fat = fat;
        this.traceElements = traceElements;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(int foodCalories) {
        this.foodCalories = foodCalories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public int getTraceElements() {
        return traceElements;
    }

    public void setTraceElements(int traceElements) {
        this.traceElements = traceElements;
    }

    public Food[] getFoodAvoid() {
        return foodAvoid;
    }

    public void setFoodAvoid(Food[] foodAvoid) {
        this.foodAvoid = foodAvoid;
    }
}
