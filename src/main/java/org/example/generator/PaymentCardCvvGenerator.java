package org.example.generator;

public class PaymentCardCvvGenerator {

    public String generatePaymentCardCvv() {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < 3; i++){
            int randomNum = (int)(Math.random() * 10);
            stringBuilder.append(randomNum);
        }
        return stringBuilder.toString();
    }
}
