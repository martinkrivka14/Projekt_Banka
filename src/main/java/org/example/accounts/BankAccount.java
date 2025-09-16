package org.example.accounts;

import org.example.customer.Customer;

public class BankAccount extends BaseBankAccount{
    public BankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid,bankAccountNumber,customer,balance);
    }
}
