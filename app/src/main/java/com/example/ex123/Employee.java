package com.example.ex123;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version 1
 * @since 27 /04/2022
 * The type Employee fb constants
 */
public class Employee {
    private int keyId;
    private String lastName;
    private String firstName;
    private String company;
    private String EmployeeId;
    private String Phone;

    /**
     * Instantiates a new Employee.
     */
    public Employee(){}

    /**
     * Instantiates a new Employee.
     *
     * @param keyId      the key id
     * @param lastName   the last name
     * @param firstName  the first name
     * @param company    the company
     * @param EmployeeId the employee id
     * @param Phone      the phone
     */
    public Employee(int keyId, String lastName, String firstName, String company, String EmployeeId, String Phone)
    {
        this.keyId = keyId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.company = company;
        this.EmployeeId = EmployeeId;
        this.Phone = Phone;
    }

    /**
     * Gets key id.
     *
     * @return the key id
     */
    public int getKeyId() {
        return keyId;
    }

    /**
     * Sets key id.
     *
     * @param keyId the key id
     */
    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public String getEmployeeId() {
        return EmployeeId;
    }

    /**
     * Sets employee id.
     *
     * @param employeeId the employee id
     */
    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        Phone = phone;
    }
}
