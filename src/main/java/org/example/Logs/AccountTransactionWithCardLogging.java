package org.example.Logs;

import org.example.accounts.BankAccountWithPaymentCards;
import org.example.cards.PaymentCard;

public class AccountTransactionWithCardLogging {

    private final BankAccountWithPaymentCards bankAccountWithPaymentCards;
    private final PaymentCard paymentCard;
    private final Boolean isAdded;
    private final double money;

    public AccountTransactionWithCardLogging(BankAccountWithPaymentCards bankAccountWithPaymentCards, PaymentCard paymentCard, Boolean isAdded, double money) {
        this.bankAccountWithPaymentCards = bankAccountWithPaymentCards;
        this.paymentCard = paymentCard;
        this.isAdded = isAdded;
        this.money = money;
    }


    public void getCardLoggingInfo(){
        System.out.println("-----Logging info-----");
        System.out.println("Bank account number: " + bankAccountWithPaymentCards.getBankAccountNumber());
        System.out.println("Payment card number: " + paymentCard.getCardNumber());
        System.out.println("You " + (isAdded == true ? "added " : "subracted ") +  money + "euros from your account");
        System.out.println("Transaction was done with your CARD");
        System.out.println("Remaining balance on your account is " + bankAccountWithPaymentCards.getBalance());
        System.out.println("-----------------------");
    }
}

