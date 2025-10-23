package org.example.services;

import org.example.Logs.AccountTransactionWithCardLogging;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.cards.PaymentCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PaymentCardService {

    public void changePin(PaymentCard paymentCard) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Type current PIN: ");
        String currentPin = sc.nextLine();
        Integer PIN = Integer.parseInt(currentPin);

        if(PIN.equals(paymentCard.getCardPin())){
            System.out.println("Your PIN is correct - now type changed PIN");
            String changePin = sc.nextLine();
            Integer PIN2 = Integer.parseInt(changePin);

            if(!PIN2.equals(paymentCard.getCardPin())){
                System.out.println("You have successfully changed your PIN to " + PIN2);
                paymentCard.setCardPin(PIN2);
            }else{
                System.out.println("Your original PIN is same as your new PIN");
            }
        }else{
            System.out.println("Your PIN is incorrect");
        }


    }

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

        Scanner sc = new Scanner(System.in);
        System.out.print("Type your PIN: ");
        String currentPin = sc.nextLine();
        Integer PIN = Integer.parseInt(currentPin);

        if(PIN.equals(paymentCard.getCardPin())){
            System.out.println("Your PIN is correct, transaction can be done");
        }
        else{
            throw new java.util.NoSuchElementException("Your pin is incorrect");
        }

        if (bankAccountNumber != null) {
            for (BankAccountWithPaymentCards account : bankAccounts) {
                if (account.getBankAccountNumber().equals(bankAccountNumber)) {
                    bankAccountService.addBalanceWithCard(account,money);
                    AccountTransactionWithCardLogging logging = new AccountTransactionWithCardLogging(account,paymentCard,isAdded,money);
                    logging.getCardLoggingInfo();
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
                    logging.getCardLoggingInfo();
                }
            }
        }else{
            throw new java.util.NoSuchElementException("Bank account with number " + null + " couldn't be found");
        }
    }
}
