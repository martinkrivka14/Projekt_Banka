package org.example.facades;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.inject.Inject;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.services.InterestCalculatorService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class InterestRunnerFacade {

    @Inject
    private InterestCalculatorService interestCalculatorService;

    private ArrayList<SaveAccount> saveAccounts = new ArrayList<>();

    private Date nextInterestDate;


    public void processAllInterests(ArrayList<BaseBankAccount> bankAccountsList){

        LocalDateTime now = LocalDateTime.now();

        if(!(saveAccounts == null)){
            saveAccounts.clear();
        }

        for (BaseBankAccount bankAccount : bankAccountsList) {
            if (bankAccount instanceof SaveAccount saveAccount) {
                saveAccounts.add(saveAccount);
            }
        }

        for (SaveAccount saveAccount : saveAccounts) {

            if (saveAccount.getNextInterestDate().isBefore(now)) {
                double interestAmount = interestCalculatorService.calculateInterest(saveAccount);
                double newBalance = saveAccount.getBalance() + interestAmount;
                saveAccount.setBalance(newBalance);

                saveAccount.setLastInterestDate(saveAccount.getNextInterestDate());
                saveAccount.setNextInterestDate(saveAccount.getLastInterestDate().plusMinutes(1));


                System.out.println("Interest " + interestAmount + " euros was adding to account " + saveAccount.getBankAccountNumber() +
                        " new balance is: " + newBalance + " next interest is at: " + saveAccount.getNextInterestDate());
            }else{
                System.out.println("No account to process interest");
            }
        }
    }
}
