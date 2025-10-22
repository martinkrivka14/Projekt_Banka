package org.example.Logs;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.cards.PaymentCard;

public class AccountTransactionLogging {

    private final BaseBankAccount bankAccount;
    private final Boolean isAdded;
    private final Double money;

    public AccountTransactionLogging(BaseBankAccount bankAccount, Boolean isAdded, Double money) {
        this.bankAccount = bankAccount;
        this.isAdded = isAdded;
        this.money = money;
    }

    public void getLoggingInformation() {
        System.out.println("-----Logging info-----");
        System.out.println("Bank account number: " + bankAccount.getBankAccountNumber());
        System.out.println("You " + (isAdded == true ? "added " : "subracted ") +  money + "euros from your account");
        System.out.println("Transaction was done from your account");
        System.out.println("Remaining balance on your account is " + bankAccount.getBalance());
        System.out.println("-----------------------");
    }

}
