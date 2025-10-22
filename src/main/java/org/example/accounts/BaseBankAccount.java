package org.example.accounts;

import org.example.customer.Customer;

public class BaseBankAccount {

    private final String uuid;

    private final String bankAccountNumber;

    private final Customer customer;

    private Double balance;

    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, Double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
    }


    public String getUuid() {
        return uuid;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }
}
