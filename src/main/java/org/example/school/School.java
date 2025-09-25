package org.example.school;

public class School {
    private String schoolName;
    private String schoolAddress;
    private String schoolEmail;
    private String schoolPhone;
    private float balance;

    public School(String schoolName, String schoolAddress, String schoolEmail, String schoolPhone, float balance) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.schoolEmail = schoolEmail;
        this.schoolPhone = schoolPhone;
        this.balance = balance;
    }


    public  String getSchoolName() {
        return schoolName;
    }
    public String getSchoolAddress() {
        return schoolAddress;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public String getSchoolPhone() {
        return schoolPhone;
    }

    public float getBalance() {
        return balance;
    }
}
