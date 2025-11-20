package org.example.factories;

import org.example.History.AccountTransaction;

import java.time.LocalDateTime;

public class AccountTransactionFactory {

    public AccountTransaction createAccountTransaction(LocalDateTime date, Boolean action, Boolean fromAccount, Double amount, Boolean success, Boolean wasDone) {
        return new AccountTransaction( action, fromAccount, amount, success, wasDone);
    }
}
