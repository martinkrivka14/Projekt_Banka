package org.example.Serialization;

import com.google.gson.Gson;
import org.example.History.AccountTransaction;
import org.example.accounts.SaveAccount;
import org.example.customer.Customer;

public class BankAccountTransactionJsonSerialization implements Serialization{

    Gson gson = new Gson();
    BankAccountTransactionSerializationFactory  bankAccountTransactionSerializationFactory = new BankAccountTransactionSerializationFactory();

    @Override
    public String serialization(Object obj) {

        if(!(obj instanceof AccountTransaction)){
            throw new RuntimeException("Illegal type for serialization");
        }

        BankAccountTransactionSerialization bankAccountTransactionSerialization = bankAccountTransactionSerializationFactory.createBankAccountTransactionSerialization((AccountTransaction) obj);


        return gson.toJson(bankAccountTransactionSerialization);

    }

    @Override
    public Object deserialization(String str) {
        return gson.fromJson(str,  AccountTransaction.class);
    }
}

