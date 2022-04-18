package com.example.ex123;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  17/02/2022
 * The type Order.
 */
public class Order {
    private String orderDate;
    private String orderTime;
    private String employeeId;
    private int mealId;
    private String company;

    public Order(){}

    public Order(String orderDate, String orderTime, String employeeId, int mealId, String company)
    {
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.employeeId = employeeId;
        this.mealId = mealId;
        this.company = company;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
