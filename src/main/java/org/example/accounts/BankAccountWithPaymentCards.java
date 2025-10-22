package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.customer.Customer;

import java.util.ArrayList;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    private ArrayList<PaymentCard> paymentCards;

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, Double balance, ArrayList<PaymentCard> paymentCards) {
        super(uuid, bankAccountNumber, customer, balance);
        this.paymentCards = paymentCards;
    }

    public ArrayList<PaymentCard> getPaymentCards() {
        return this.paymentCards;
    }
}
