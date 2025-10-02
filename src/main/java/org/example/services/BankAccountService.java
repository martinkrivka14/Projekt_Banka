package org.example.services;

import org.example.accounts.BaseBankAccount;

public class BankAccountService {


    TransactionValidationService transactionValidationService = new TransactionValidationService();

    public void addBalance(BaseBankAccount account, Double balance) {
            transactionValidationService.NegativeBalance(account, balance, true); //checking balance
            transactionValidationService.Validation(account, balance);  //checking 10 000 euro limit
            account.setBalance(account.getBalance() + balance); //adding money
    }

    public void subractedBalance(BaseBankAccount account, Double balance){

         double subtractBalance = account.getBalance() - balance;
         transactionValidationService.NoMoney(account, subtractBalance);
        transactionValidationService.NegativeBalance(account, balance, false);
         account.setBalance(subtractBalance);

    }
}
