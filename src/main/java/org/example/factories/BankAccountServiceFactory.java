package org.example.factories;

import org.example.accounts.BaseBankAccount;

public class BankAccountServiceFactory {

    public void addBalance(BaseBankAccount account, Double balance) {
        account.setBalance(account.getBalance() + balance);
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
