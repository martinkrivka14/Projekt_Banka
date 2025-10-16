package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.customer.Customer;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, Double balance) {
        super(uuid, bankAccountNumber, customer, balance);
    }

}
