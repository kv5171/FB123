package com.example.ex123;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  17/02/2022
 * The type Company database constants
 */
public class Company {
    private int companyNumber;
    private String name;
    private String firstPhone;
    private String secondPhone;

    public Company(){}

    public Company(int companyNumber, String name, String firstPhone, String secondPhone)
    {
        this.companyNumber = companyNumber;
        this.name = name;
        this.firstPhone = firstPhone;
        this.secondPhone = secondPhone;
    }

    public String getFirstPhone() {
        return firstPhone;
    }

    public void setFirstPhone(String firstPhone) {
        this.firstPhone = firstPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }
}
