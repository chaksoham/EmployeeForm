package com.example;

/**
 * Created by schakra on 11/8/16.
 */
public class Employee {
    private String name;
    private String emailId;
    private String dob;

    public Employee(String name, String emailId, String dob) {
        this.name = name;
        this.emailId = emailId;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
