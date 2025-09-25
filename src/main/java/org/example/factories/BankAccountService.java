package org.example.factories;

import org.example.accounts.BaseBankAccount;

public class BankAccountService {

    public void addBalance(BaseBankAccount account, Double balance) {


        TransactionValidationService transactionValidationService = new TransactionValidationService();

        if(account.getBalance() >= 0) {
            throw new IllegalArgumentException("Cannot add negative balance");
        }
        else{
            account.setBalance(account.getBalance() + balance);
            //transactionValidationService.Validation(account, balance);
        }

    }

    public void subractedBalance(BaseBankAccount account, Double balance) throws IllegalArgumentException {

         double subtractBalance = account.getBalance() - balance;

        if (subtractBalance < 0) {
            throw new IllegalArgumentException("Lack of money on your bank account");
        } else {
            account.setBalance(subtractBalance);
        }
    }
}
