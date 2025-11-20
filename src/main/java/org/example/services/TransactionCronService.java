package org.example.services;

import jakarta.inject.Inject;
import org.example.History.AccountTransaction;
import org.example.accounts.BaseBankAccount;
import org.example.facades.InterestRunnerFacade;
import org.example.facades.TransactionHistoryFacade;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TransactionCronService {

    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final TransactionHistoryFacade  transactionHistoryFacade;


    @Inject
    public TransactionCronService(TransactionHistoryFacade transactionHistoryFacade) {
        this.transactionHistoryFacade = transactionHistoryFacade;
    }


    public void start(ArrayList<BaseBankAccount> bankAccountsList) {
        System.out.println("TransactionCronService started...");

        scheduler.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Generating transactions file: " + java.time.LocalDateTime.now() + " press Enter for ending an Cron");
                transactionHistoryFacade.processAllTransactions(bankAccountsList);
            } catch (Exception e) {
                System.err.println("Error in generating " + e.getMessage());
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.MINUTES);
    }

    public void stop() {
        scheduler.shutdown();
        System.out.println("TransactionCronService stopped.");
    }

}
