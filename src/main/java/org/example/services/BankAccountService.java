package org.example.services;

import org.example.accounts.BaseBankAccount;
import org.example.cards.PaymentCard;

import java.util.HashMap;
import java.util.Map;

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

    public void addCardToBankAccount(BaseBankAccount account, PaymentCard paymentCard, HashMap<String,String> bankVCard){

        bankVCard.put(paymentCard.getCardNumber(),account.getBankAccountNumber());
        System.out.println(bankVCard);
    }

    public void allCardsForThisBankAccount(BaseBankAccount account, HashMap<String,String> bankVCard) {
        String bankAccountNumber = account.getBankAccountNumber();
        
        String foundedCard =  null;

        System.out.println("Bank account number: " + bankAccountNumber + " has those cards");

        for (Map.Entry<String, String> entry : bankVCard.entrySet()) {
            if (bankAccountNumber.equals(entry.getValue())) {

                foundedCard = entry.getKey();
                System.out.println("Founded card " + foundedCard);
            }
        }
    }
}
