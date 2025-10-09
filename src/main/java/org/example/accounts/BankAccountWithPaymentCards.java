package org.example.accounts;

import org.example.cards.PaymentCard;
import org.example.customer.Customer;

public class BankAccountWithPaymentCards extends BaseBankAccount {

    private final PaymentCard paymentCard;

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, Double balance,  PaymentCard paymentCard) {
        super(uuid, bankAccountNumber, customer, balance);
        this.paymentCard = paymentCard;
    }


    public PaymentCard getPaymentCard() {return paymentCard;}
}
