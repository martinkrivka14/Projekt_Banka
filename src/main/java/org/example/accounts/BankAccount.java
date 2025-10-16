package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.customer.Customer;

public class BankAccount extends BankAccountWithPaymentCards {

    public BankAccount(String uuid, String bankAccountNumber, Customer customer, Double balance) {
        super(uuid, bankAccountNumber, customer, balance);
    }
}
