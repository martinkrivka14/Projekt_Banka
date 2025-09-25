package org.example.factories;

import org.example.accounts.BaseBankAccount;

public class TransactionValidationService {


    public TransactionValidationService(){
    }

    public void Validation(BaseBankAccount account, Double balance){
        if(balance >= 10000){
            throw new IllegalArgumentException("Deposing over 10 000 euros has to be reported");
        }
    }
}
