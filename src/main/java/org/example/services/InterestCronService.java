package org.example.services;

import jakarta.inject.Inject;
import org.example.accounts.BaseBankAccount;
import org.example.facades.InterestRunnerFacade;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InterestCronService {


    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final InterestRunnerFacade interestRunnerFacade;

    @Inject
    public InterestCronService(InterestRunnerFacade interestRunnerFacade, ArrayList<BaseBankAccount> bankAccountsList) {
        this.interestRunnerFacade = interestRunnerFacade;
    }

    public void start(ArrayList<BaseBankAccount> bankAccountsList) {
        System.out.println("InterestCronService started...");

        scheduler.scheduleAtFixedRate(() -> {
            try {
                System.out.println("Starting interesting process: " + java.time.LocalDateTime.now() + " press Enter for ending an Cron");
                interestRunnerFacade.processAllInterests(bankAccountsList);
            } catch (Exception e) {
                System.err.println("Error in interesting account " + e.getMessage());
                e.printStackTrace();
            }
        }, 0, 18, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdownNow();
        System.out.println("InterestCronService stopped.");
    }


}
