package com.example.ex123;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version 1
 * @since 27 /04/2022
 * The type Company fb constants
 */
public class Company {
    private int companyNumber;
    private String name;
    private String firstPhone;
    private String secondPhone;

    /**
     * Instantiates a new Company.
     */
    public Company(){}

    /**
     * Instantiates a new Company.
     *
     * @param companyNumber the company number
     * @param name          the name
     * @param firstPhone    the first phone
     * @param secondPhone   the second phone
     */
    public Company(int companyNumber, String name, String firstPhone, String secondPhone)
    {
        this.companyNumber = companyNumber;
        this.name = name;
        this.firstPhone = firstPhone;
        this.secondPhone = secondPhone;
    }

    /**
     * Gets first phone.
     *
     * @return the first phone
     */
    public String getFirstPhone() {
        return firstPhone;
    }

    /**
     * Sets first phone.
     *
     * @param firstPhone the first phone
     */
    public void setFirstPhone(String firstPhone) {
        this.firstPhone = firstPhone;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets second phone.
     *
     * @return the second phone
     */
    public String getSecondPhone() {
        return secondPhone;
    }

    /**
     * Sets second phone.
     *
     * @param secondPhone the second phone
     */
    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    /**
     * Gets company number.
     *
     * @return the company number
     */
    public int getCompanyNumber() {
        return companyNumber;
    }

    /**
     * Sets company number.
     *
     * @param companyNumber the company number
     */
    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }
}
