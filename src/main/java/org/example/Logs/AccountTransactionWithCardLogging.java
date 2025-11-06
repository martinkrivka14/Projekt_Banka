package org.example.Logs;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.cards.PaymentCard;

public class AccountTransactionWithCardLogging {

    private final BaseBankAccount baseBankAccount;
    private final PaymentCard paymentCard;
    private final Boolean isAdded;
    private final double money;

    public AccountTransactionWithCardLogging(BaseBankAccount baseBankAccount, PaymentCard paymentCard, Boolean isAdded, double money) {
        this.baseBankAccount = baseBankAccount;
        this.paymentCard = paymentCard;
        this.isAdded = isAdded;
        this.money = money;
    }


    public void getCardLoggingInfo(){
        System.out.println("-----Logging info-----");
        System.out.println("Bank account number: " + baseBankAccount.getBankAccountNumber());
        System.out.println("Payment card number: " + paymentCard.getCardNumber());
        System.out.println("You " + (isAdded == true ? "added " : "subracted ") +  money + "euros from your account");
        System.out.println("Transaction was done with your CARD");
        System.out.println("Remaining balance on your account is " + baseBankAccount.getBalance());
        System.out.println("-----------------------");
    }
}

