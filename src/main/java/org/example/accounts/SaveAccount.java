package org.example.accounts;

import org.example.customer.Customer;

public class SaveAccount extends BaseBankAccount{
    private float interestRate;
    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, float interestRate) {
        super(uuid,bankAccountNumber,customer,balance);
        this.interestRate = interestRate;

    }

    public float getInterestRate() {
        return interestRate;
    }
}