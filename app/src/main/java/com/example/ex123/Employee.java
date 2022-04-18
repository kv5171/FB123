package com.example.ex123;

/**
 * @author Keren Weintraub <kv5171@bs.amalnet.k12.il>
 * @version	1
 * @since  17/02/2022
 * The type Employee database constants
 */
public class Employee {
    private int keyId;
    private String lastName;
    private String firstName;
    private String company;
    private String EmployeeId;
    private String Phone;

    public Employee(){}

    public Employee(int keyId, String lastName, String firstName, String company, String EmployeeId, String Phone)
    {
        this.keyId = keyId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.company = company;
        this.EmployeeId = EmployeeId;
        this.Phone = Phone;
    }

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
