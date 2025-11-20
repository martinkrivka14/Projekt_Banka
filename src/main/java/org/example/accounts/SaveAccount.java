package org.example.accounts;

import org.example.History.AccountTransaction;
import org.example.customer.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class SaveAccount extends BaseBankAccount{
    private float interestRate;
    private LocalDate openingDate;
    private LocalDateTime lastInterestDate;
    private LocalDateTime nextInterestDate;
    private ArrayList<AccountTransaction> accountTransactions;


    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, float interestRate,  LocalDate openingDate, LocalDateTime lastInterestDate, ArrayList<AccountTransaction> accountTransactions) {
        super(uuid,bankAccountNumber,customer,balance);
        this.interestRate = interestRate;
        this.openingDate = openingDate;
        this.lastInterestDate = lastInterestDate;

        if (lastInterestDate != null) {
            this.nextInterestDate = lastInterestDate.plusMinutes(1);
        } else {
            this.nextInterestDate = LocalDateTime.now().plusMinutes(1);
        }
        this.accountTransactions = accountTransactions;

    }

    public float getInterestRate() {
        return interestRate;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public LocalDateTime getLastInterestDate() {
        return lastInterestDate;
    }

    public void setLastInterestDate(LocalDateTime lastInterestDate) {
        this.lastInterestDate = lastInterestDate;
    }

    public LocalDateTime getNextInterestDate() {
        return nextInterestDate;
    }

    public void setNextInterestDate(LocalDateTime nextInterestDate) {
        this.nextInterestDate = nextInterestDate;
    }

    public ArrayList<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(ArrayList<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }


}