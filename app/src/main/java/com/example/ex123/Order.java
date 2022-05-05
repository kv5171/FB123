package com.example.ex123;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version 1
 * @since 27 /04/2022
 * The type Order.
 */
public class Order {
    private String orderDate;
    private String orderTime;
    private String employeeId;
    private int mealId;
    private String company;

    /**
     * Instantiates a new Order.
     */
    public Order(){}

    /**
     * Instantiates a new Order.
     *
     * @param orderDate  the order date
     * @param orderTime  the order time
     * @param employeeId the employee id
     * @param mealId     the meal id
     * @param company    the company
     */
    public Order(String orderDate, String orderTime, String employeeId, int mealId, String company)
    {
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.employeeId = employeeId;
        this.mealId = mealId;
        this.company = company;
    }

    /**
     * Gets order date.
     *
     * @return the order date
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * Sets order date.
     *
     * @param orderDate the order date
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets order time.
     *
     * @return the order time
     */
    public String getOrderTime() {
        return orderTime;
    }

    /**
     * Sets order time.
     *
     * @param orderTime the order time
     */
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets employee id.
     *
     * @param employeeId the employee id
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
     * Gets company.
     *
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets company.
     *
     * @param company the company
     */
    public void setCompany(String company) {
        this.company = company;
    }
}
