package org.example.services;

import org.example.Logs.AccountTransactionWithCardLogging;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.cards.PaymentCard;

import java.util.ArrayList;
import java.util.HashMap;

public class PaymentCardService {



    public void addBankAccountToCard( PaymentCard paymentCard,BaseBankAccount account,HashMap<String,String> bankVCard){

        bankVCard.put(paymentCard.getCardNumber(),account.getBankAccountNumber());
        System.out.println(bankVCard);
    }

    public void getBankAccountByPaymentCardNumber(PaymentCard paymentCard,HashMap<String,String> bankVCard){
        String bankAccountNumber = bankVCard.get(paymentCard.getCardNumber());

        if(bankAccountNumber != null){
            System.out.println("Bank account number: " + bankAccountNumber);
        } else {

            throw new java.util.NoSuchElementException("Couldn't find a bank account");
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

            throw new java.util.NoSuchElementException("Bank account with number " + bankAccountNumber + " couldn't be found");
        } else {
            throw new java.util.NoSuchElementException("Card with number  " + cardNumber + "couldn't be found.");

        }

    }

    public void addBalanceToBankAccount(PaymentCard paymentCard,HashMap<String,String> bankVCard, ArrayList <BankAccountWithPaymentCards> bankAccounts, double money){

        Boolean isAdded = true;

        String cardNumber = paymentCard.getCardNumber();
        String bankAccountNumber = bankVCard.get(cardNumber);

        BankAccountService bankAccountService = new BankAccountService();

        if (bankAccountNumber != null) {
            for (BankAccountWithPaymentCards account : bankAccounts) {
                if (account.getBankAccountNumber().equals(bankAccountNumber)) {
                    bankAccountService.addBalanceWithCard(account,money);
                    AccountTransactionWithCardLogging logging = new AccountTransactionWithCardLogging(account,paymentCard,isAdded,money);
                    logging.getLoggingInfo();
                }
            }
        }else{
            throw new java.util.NoSuchElementException("Bank account with number " + null + " couldn't be found");
        }
    }

    public void subtractBalanceFromBankAccount(PaymentCard paymentCard, HashMap<String,String> bankVCard, ArrayList<BankAccountWithPaymentCards> bankAccounts, double money){

        Boolean isAdded = false;

        String cardNumber = paymentCard.getCardNumber();
        String bankAccountNumber = bankVCard.get(cardNumber);

        BankAccountService bankAccountService = new BankAccountService();

        if(bankAccountNumber != null){
            for (BankAccountWithPaymentCards account : bankAccounts) {
                if(account.getBankAccountNumber().equals(bankAccountNumber)){
                    bankAccountService.subractedBalanceWithCard(account,money);
                    AccountTransactionWithCardLogging logging = new AccountTransactionWithCardLogging(account,paymentCard,isAdded,money);
                    logging.getLoggingInfo();
                }
            }
        }else{
            throw new java.util.NoSuchElementException("Bank account with number " + null + " couldn't be found");
        }






    }



}
