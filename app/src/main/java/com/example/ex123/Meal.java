package com.example.ex123;

/**
 * The type Meal.
 *
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version 1
 * @since 27 /04/2022 The type Meal.
 */
public class Meal {
    private int mealId;
    private String firstMeal;
    private String mainMeal;
    private String extra;
    private String dessert;
    private String drink;

    /**
     * Instantiates a new Meal.
     */
    public Meal(){}

    /**
     * Instantiates a new Meal.
     *
     * @param mealId    the meal id
     * @param firstMeal the first meal
     * @param mainMeal  the main meal
     * @param extra     the extra
     * @param dessert   the dessert
     * @param drink     the drink
     */
    public Meal(int mealId, String firstMeal, String mainMeal, String extra, String dessert, String drink)
    {
        this.mealId = mealId;
        this.firstMeal = firstMeal;
        this.mainMeal = mainMeal;
        this.extra = extra;
        this.dessert = dessert;
        this.drink = drink;
    }

    /**
     * Gets meal id.
     *
     * @return the meal id
     */
    public int getMealId() {
        return mealId;
    }

    /**
     * Sets meal id.
     *
     * @param mealId the meal id
     */
    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    /**
     * Gets first meal.
     *
     * @return the first meal
     */
    public String getFirstMeal() {
        return firstMeal;
    }

    /**
     * Sets first meal.
     *
     * @param firstMeal the first meal
     */
    public void setFirstMeal(String firstMeal) {
        this.firstMeal = firstMeal;
    }

    /**
     * Gets main meal.
     *
     * @return the main meal
     */
    public String getMainMeal() {
        return mainMeal;
    }

    /**
     * Sets main meal.
     *
     * @param mainMeal the main meal
     */
    public void setMainMeal(String mainMeal) {
        this.mainMeal = mainMeal;
    }

    /**
     * Gets extra.
     *
     * @return the extra
     */
    public String getExtra() {
        return extra;
    }

    /**
     * Sets extra.
     *
     * @param extra the extra
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

    /**
     * Gets dessert.
     *
     * @return the dessert
     */
    public String getDessert() {
        return dessert;
    }

    /**
     * Sets dessert.
     *
     * @param dessert the dessert
     */
    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    /**
     * Gets drink.
     *
     * @return the drink
     */
    public String getDrink() {
        return drink;
    }

    /**
     * Sets drink.
     *
     * @param drink the drink
     */
    public void setDrink(String drink) {
        this.drink = drink;
    }
}
