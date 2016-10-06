package com.dietkeeper.app.model;

/**
 * Created by Elrol on 2016/10/6.
 */
public class User {
    private int id;
    private String userName;
    private int userCalories;
    private String[] userFood;
    private String[] userBreakfast;
    private String[] userLunch;
    private String[] userDinner;

    public String[] getUserDinner() {
        return userDinner;
    }

    public void setUserDinner(String[] userDinner) {
        this.userDinner = userDinner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserCalories() {
        return userCalories;
    }

    public void setUserCalories(int userCalories) {
        this.userCalories = userCalories;
    }

    public String[] getUserFood() {
        return userFood;
    }

    public void setUserFood(String[] userFood) {
        this.userFood = userFood;
    }

    public String[] getUserBreakfast() {
        return userBreakfast;
    }

    public void setUserBreakfast(String[] userBreakfast) {
        this.userBreakfast = userBreakfast;
    }

    public String[] getUserLunch() {
        return userLunch;
    }

    public void setUserLunch(String[] userLunch) {
        this.userLunch = userLunch;
    }
}
