package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.customer.Customer;
import org.example.school.School;

import java.util.ArrayList;

public class StudentAccount extends BankAccountWithPaymentCards {

    private String schoolType;
    private float interestRate;
    private School school;
    public StudentAccount(String uuid, String bankAccountNumber, Customer customer, double balance, School school, ArrayList<PaymentCard> paymentCards) {
        super(uuid,bankAccountNumber,customer,balance,paymentCards);
        this.school = school;
    }

    /*
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
    }*/
}
