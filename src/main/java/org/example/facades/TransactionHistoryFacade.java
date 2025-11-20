package org.example.facades;

import org.checkerframework.checker.units.qual.Time;
import org.example.History.AccountTransaction;
import org.example.Serialization.BankAccountTransactionJsonSerialization;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static java.awt.SystemColor.text;
import static java.lang.String.valueOf;

public class TransactionHistoryFacade {

    private BankAccountTransactionJsonSerialization jsonSerialization = new BankAccountTransactionJsonSerialization();

    public void processAllTransactions(ArrayList<BaseBankAccount> bankAccountsList){

        Date date = new Date();
        String minute = valueOf(date.getMinutes());

        StringBuilder allData = new StringBuilder(new String());

        for(BaseBankAccount bankAccount : bankAccountsList){
            if(bankAccount instanceof SaveAccount saveAccount){
                ArrayList<AccountTransaction> accountTransactions =  saveAccount.getAccountTransactions();
                for(AccountTransaction accountTransaction : accountTransactions){
                    if(accountTransaction.getWasDone() == false){
                        allData.append(saveAccount.getBankAccountNumber());
                        allData.append(jsonSerialization.serialization(accountTransaction));
                    }
                    accountTransaction.setWasDone(true);
                }
            }
        }

        Path path = Paths.get("C:\\Users\\ADMIN\\Desktop\\file"+ minute + ".txt");

        try {
            Files.writeString(path, allData.toString(), StandardCharsets.UTF_8);
        }

        catch (IOException ex) {
            System.out.print("Invalid Path");
        }


    }
}
