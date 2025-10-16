package org.example.services;

import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.cards.PaymentCard;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentCardService {



    public void addToBankAccount( PaymentCard paymentCard,BaseBankAccount account,HashMap<String,String> bankVCard){

        bankVCard.put(paymentCard.getCardNumber(),account.getBankAccountNumber());
        System.out.println(bankVCard);
    }

    public void getBankAccountByPaymentCardNumber(PaymentCard paymentCard,HashMap<String,String> bankVCard){
        String bankAccountNumber = bankVCard.get(paymentCard.getCardNumber());

        if(bankAccountNumber != null){
            System.out.println("Bank account number: " + bankAccountNumber);
        } else {
            System.out.println("Couldn't find bank account number");
        }
    }

    public void getBankAccountBalanceByPaymentCardNumber(PaymentCard paymentCard, HashMap<String,String> bankVCard, ArrayList<BankAccountWithPaymentCards> bankAccounts){

        String cardNumber = paymentCard.getCardNumber();

        String bankAccountNumber = bankVCard.get(cardNumber);

        if (bankAccountNumber != null) {
            for (BankAccountWithPaymentCards account : bankAccounts) {
                if (account.getBankAccountNumber().equals(bankAccountNumber)) {
                    System.out.println("Money on the bank account  " + bankAccountNumber + " with card " + paymentCard.getCardNumber() +"is : " + account.getBalance());
                    return;
                }
            }

            System.out.println("Error: Bank account with number " + bankAccountNumber + " couldn't be found");
        } else {

            System.out.println("Error: Card with number  " + cardNumber + "couldn't be found.");
        }

    }

    public void addBalanceToBankAccount(PaymentCard paymentCard,HashMap<String,String> bankVCard, ArrayList <BankAccountWithPaymentCards> bankAccounts, double money){
        String cardNumber = paymentCard.getCardNumber();
        String bankAccountNumber = bankVCard.get(cardNumber);

        BankAccountService bankAccountService = new BankAccountService();

        if (bankAccountNumber != null) {
            for (BankAccountWithPaymentCards account : bankAccounts) {
                if (account.getBankAccountNumber().equals(bankAccountNumber)) {
                    bankAccountService.addBalance(account,money);
                }
            }
        }else{
            System.out.println("Error: Bank account with number " + null + " couldn't be found");
        }



    }

    public void subtractBalanceToBankAccount(PaymentCard paymentCard, HashMap<String,String> bankVCard, ArrayList<BankAccountWithPaymentCards> bankAccounts, double money){
        String cardNumber = paymentCard.getCardNumber();
        String bankAccountNumber = bankVCard.get(cardNumber);

        BankAccountService bankAccountService = new BankAccountService();

        if(bankAccountNumber != null){
            for (BankAccountWithPaymentCards account : bankAccounts) {
                if(account.getBankAccountNumber().equals(bankAccountNumber)){
                    bankAccountService.subractedBalance(account,money);
                }
            }
        }else{
            System.out.println("Error: Bank account with number " + null + " couldn't be found");
        }






    }



}
