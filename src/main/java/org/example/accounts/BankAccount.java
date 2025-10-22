package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.customer.Customer;

import java.util.ArrayList;

public class BankAccount extends BankAccountWithPaymentCards {

    public BankAccount(String uuid, String bankAccountNumber, Customer customer, Double balance, ArrayList<PaymentCard> paymentCards) {
        super(uuid, bankAccountNumber, customer, balance,paymentCards);
    }
}
