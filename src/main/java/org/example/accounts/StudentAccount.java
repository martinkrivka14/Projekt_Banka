package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.customer.Customer;
import org.example.school.HighSchool;
import org.example.school.School;
import org.example.school.University;

public class StudentAccount extends BankAccountWithPaymentCards {

    private String schoolType;
    private float interestRate;
    private School school;
    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, double balance,float interestRate, School school, PaymentCard paymentCard) {
        super(uuid,bankAccountNumber,customer,balance,paymentCard);
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
