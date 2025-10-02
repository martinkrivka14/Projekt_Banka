package org.example.services;

import org.example.accounts.BaseBankAccount;

public class TransactionValidationService {


    public TransactionValidationService(){
    }

    public void Validation(BaseBankAccount account, Double balance){
        if(balance > 10000){
            throw new IllegalArgumentException("Deposing over 10 000 euros has to be reported");
        }
    }

    public void NegativeBalance(BaseBankAccount account, Double balance, String exepction){
        if(balance < 0){
            throw new IllegalArgumentException(exepction);
        }
    }

    public void NoMoney(BaseBankAccount account, Double balance){
        if(balance < 0){
            throw new IllegalArgumentException("Lack of money on your bank account");
        }
    }
}
