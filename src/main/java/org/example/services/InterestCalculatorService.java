package org.example.services;

import org.example.accounts.SaveAccount;

public class InterestCalculatorService {

    public double calculateInterest(SaveAccount saveAccount) {
        double balance = saveAccount.getBalance();
        float interestRate = saveAccount.getInterestRate();

        double interest = balance * (interestRate / 100.0);

        System.out.println("Calculated interest for account " + saveAccount.getBankAccountNumber() +
                " (rate: " + interestRate + "%, balance: " + balance + ") = " + interest);

        return interest;
    }
}
