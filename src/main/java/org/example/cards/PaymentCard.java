package org.example.cards;

public class PaymentCard {

    private String cardNumber;

    private String customer;

    private String cardExpirationDate;

    private String cardCVV;

    private Integer PIN;


    public PaymentCard(String cardNumber, String customer, String cardExpirationDate, String cardCVV, Integer PIN) {
        this.cardNumber = cardNumber;
        this.customer = customer;
        this.cardExpirationDate = cardExpirationDate;
        this.cardCVV = cardCVV;
        this.PIN = PIN;
    }



    public void getPaymentCardInfo(){
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Customer Name: " + customer);
        System.out.println("Card Expiration Date: " + cardExpirationDate);
        System.out.println("Card CVV: " + cardCVV);
        System.out.println("Card PIN: " + PIN);
        System.out.println("------------------------");

    }

    public String getCardNumber() {
        return cardNumber;
    }

}