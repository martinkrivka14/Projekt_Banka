package org.example.services;

import org.example.accounts.BaseBankAccount;

public class BankAccountService {


    TransactionValidationService transactionValidationService = new TransactionValidationService();

    public void addBalance(BaseBankAccount account, Double balance) {
            String exception = "Cannot add negative balance";
            transactionValidationService.NegativeBalance(account, balance, exception); //checking balance
            transactionValidationService.Validation(account, balance);  //checking 10 000 euro limit
            account.setBalance(account.getBalance() + balance); //adding money
    }

    public void subractedBalance(BaseBankAccount account, Double balance){

         double subtractBalance = account.getBalance() - balance;
         String  exception = "Cannot withdraw negative balance";
         transactionValidationService.NoMoney(account, subtractBalance);
        transactionValidationService.NegativeBalance(account, balance,exception );
         account.setBalance(subtractBalance);

    }
}
