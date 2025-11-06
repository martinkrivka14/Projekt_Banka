package org.example.accounts;

import org.example.customer.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SaveAccount extends BaseBankAccount{
    private float interestRate;
    private LocalDate openingDate;
    private LocalDateTime lastInterestDate;
    private LocalDateTime nextInterestDate;
    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, double balance, float interestRate,  LocalDate openingDate, LocalDateTime lastInterestDate) {
        super(uuid,bankAccountNumber,customer,balance);
        this.interestRate = interestRate;
        this.openingDate = openingDate;
        this.lastInterestDate = lastInterestDate;

        if (lastInterestDate != null) {
            this.nextInterestDate = lastInterestDate.plusMinutes(1);
        } else {
            this.nextInterestDate = LocalDateTime.now().plusMinutes(1);
        }

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

}