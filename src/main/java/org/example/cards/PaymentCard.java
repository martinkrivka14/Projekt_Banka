package org.example.cards;

public class PaymentCard {

    private String cardNumber;

    private String customer;

    private String cardExpirationDate;

    private String cardCVV;


    public PaymentCard(String cardNumber, String customer, String cardExpirationDate, String cardCVV) {
        this.cardNumber = cardNumber;
        this.customer = customer;
        this.cardExpirationDate = cardExpirationDate;
        this.cardCVV = cardCVV;
    }



    public void paymentCardInfo(){
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Customer Name: " + customer);
        System.out.println("Card Expiration Date: " + cardExpirationDate);
        System.out.println("Card CVV: " + cardCVV);

    }



}
