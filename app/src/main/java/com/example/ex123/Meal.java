package com.example.ex123;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  17/02/2022
 * The type Meal.
 */
public class Meal {
    private int mealId;
    private String firstMeal;
    private String mainMeal;
    private String extra;
    private String dessert;
    private String drink;

    public Meal(){}

    public Meal(int mealId, String firstMeal, String mainMeal, String extra, String dessert, String drink)
    {
        this.mealId = mealId;
        this.firstMeal = firstMeal;
        this.mainMeal = mainMeal;
        this.extra = extra;
        this.dessert = dessert;
        this.drink = drink;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getFirstMeal() {
        return firstMeal;
    }

    public void setFirstMeal(String firstMeal) {
        this.firstMeal = firstMeal;
    }

    public String getMainMeal() {
        return mainMeal;
    }

    public void setMainMeal(String mainMeal) {
        this.mainMeal = mainMeal;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}
