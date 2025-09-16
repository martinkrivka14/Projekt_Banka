package org.example.school;

public class University extends School{
    private int length;

    public University(String schoolName, String schoolAddress, String schoolEmail, String schoolPhone, float balance, int length){
        super(schoolName,schoolAddress,schoolEmail,schoolPhone,balance);
        this.length=length;
    }

    public int getLength(){
        return length;
    }
}
