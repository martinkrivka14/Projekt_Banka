package org.example.services;

import org.example.History.AccountTransaction;
import org.example.Logs.AccountTransactionLogging;
import org.example.Logs.AccountTransactionWithCardLogging;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.cards.PaymentCard;
import org.example.factories.AccountTransactionFactory;
import org.example.factories.BankAccountFactory;
import org.example.generator.BankAccountNumberGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAccountService {



    TransactionValidationService transactionValidationService = new TransactionValidationService();

    public void addBalance(BaseBankAccount account, Double balance) {
        Boolean isAdded = true;

        String exception = "Cannot add negative balance";
        transactionValidationService.NegativeBalance(account, balance, exception); //checking balance
        transactionValidationService.Validation(balance);  //checking 10 000 euro limit
        account.setBalance(account.getBalance() + balance); //adding money


        AccountTransactionLogging logging = new AccountTransactionLogging(account,isAdded,balance);
        logging.getAccountLoggingInfo();

        LocalDateTime now = LocalDateTime.now();
        AccountTransactionFactory accountTransactionFactory = new AccountTransactionFactory();
        AccountTransaction transaction = accountTransactionFactory.createAccountTransaction(now, true, true, balance,true,false);
        if(account instanceof SaveAccount saveAccount){
            ArrayList<AccountTransaction> accountTransactions =  saveAccount.getAccountTransactions();
            accountTransactions.add(transaction);
            saveAccount.setAccountTransactions(accountTransactions);
        }
    }

    public void subractedBalance(BaseBankAccount account, Double balance){

        Boolean isAdded = false;

        double subtractBalance = account.getBalance() - balance;
        String  exception = "Cannot withdraw negative balance";
        transactionValidationService.NoMoney(account,balance);
        transactionValidationService.NegativeBalance(account, balance,exception );

        account.setBalance(subtractBalance); //subtracting money

        AccountTransactionLogging logging = new AccountTransactionLogging(account,isAdded,balance);
        logging.getAccountLoggingInfo();

        LocalDateTime now = LocalDateTime.now();
        AccountTransactionFactory accountTransactionFactory = new AccountTransactionFactory();
        AccountTransaction transaction = accountTransactionFactory.createAccountTransaction(now, false, true, balance,true,false);
        if(account instanceof SaveAccount saveAccount){
            ArrayList<AccountTransaction> accountTransactions =  saveAccount.getAccountTransactions();
            accountTransactions.add(transaction);
            saveAccount.setAccountTransactions(accountTransactions);
        }

    }

    public void addBalanceWithCard(BaseBankAccount account, Double balance){

        String exception = "Cannot add negative balance";
        transactionValidationService.NegativeBalance(account, balance, exception); //checking balance
        transactionValidationService.Validation(balance);  //checking 10 000 euro limit

        account.setBalance(account.getBalance() + balance); //adding money

        LocalDateTime now = LocalDateTime.now();
        AccountTransactionFactory accountTransactionFactory = new AccountTransactionFactory();
        AccountTransaction transaction = accountTransactionFactory.createAccountTransaction(now, true, false, balance,true,false);
        if(account instanceof SaveAccount saveAccount){
            ArrayList<AccountTransaction> accountTransactions =  saveAccount.getAccountTransactions();
            accountTransactions.add(transaction);
            saveAccount.setAccountTransactions(accountTransactions);
        }
    }


    public void subractedBalanceWithCard(BaseBankAccount account, Double balance){

        double subtractBalance = account.getBalance() - balance;
        String  exception = "Cannot withdraw negative balance";
        transactionValidationService.NoMoney(account, balance);
        transactionValidationService.NegativeBalance(account, balance,exception);

        account.setBalance(subtractBalance); //subtracting money

        LocalDateTime now = LocalDateTime.now();
        AccountTransactionFactory accountTransactionFactory = new AccountTransactionFactory();
        AccountTransaction transaction = accountTransactionFactory.createAccountTransaction(now, false, false, balance,true,false);
        if(account instanceof SaveAccount saveAccount){
            ArrayList<AccountTransaction> accountTransactions =  saveAccount.getAccountTransactions();
            accountTransactions.add(transaction);
            saveAccount.setAccountTransactions(accountTransactions);
        }

    }

    public void addCardToBankAccount(BaseBankAccount account, PaymentCard paymentCard, HashMap<String,String> bankVCard){

        bankVCard.put(paymentCard.getCardNumber(),account.getBankAccountNumber());
        System.out.println("Map of cards and their cards " + bankVCard);
    }

    public void removeCardFromBankAccount(BaseBankAccount account, PaymentCard paymentCard, HashMap<String,String> bankVCard){

        if(bankVCard.containsKey(paymentCard.getCardNumber())){
            bankVCard.remove(paymentCard.getCardNumber());
            System.out.println("Map of cards and their cards " + bankVCard);
        }
        else{
            throw new java.util.NoSuchElementException("No card found");
        }

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
            else{
                throw new java.util.NoSuchElementException("No card found");
            }
        }
    }
}
