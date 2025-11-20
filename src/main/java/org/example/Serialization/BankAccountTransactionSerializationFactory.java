package org.example.Serialization;

import org.example.History.AccountTransaction;

public class BankAccountTransactionSerializationFactory {

    public BankAccountTransactionSerialization createBankAccountTransactionSerialization(AccountTransaction accountTransaction){

        BankAccountTransactionSerialization  bankAccountTransactionSerialization = new BankAccountTransactionSerialization();

        bankAccountTransactionSerialization.action = accountTransaction.getAction();
        bankAccountTransactionSerialization.fromAccount = accountTransaction.getFromAccount();
        bankAccountTransactionSerialization.amount = accountTransaction.getAmount();
        bankAccountTransactionSerialization.wasDone = accountTransaction.getWasDone();
        bankAccountTransactionSerialization.success = accountTransaction.getSuccess();

        return bankAccountTransactionSerialization;

    }
}
