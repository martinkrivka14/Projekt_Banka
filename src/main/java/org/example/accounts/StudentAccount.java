package org.example.accounts;

import org.example.customer.Customer;
import org.example.school.HighSchool;
import org.example.school.School;
import org.example.school.University;

public class StudentAccount extends BaseBankAccount {

    private String schoolType;
    private float interestRate;
    private School school;
    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, double balance,float interestRate, School school) {
        super(uuid,bankAccountNumber,customer,balance);
        this.interestRate = interestRate;
        this.school = school;
    }


    public float getInterestRate() {
        if(school instanceof University){
            return 5.0F;
        }
        else if(school instanceof HighSchool){
            return 3.0F;
        }
        else{
            return 1.0F;
        }
    }
}
