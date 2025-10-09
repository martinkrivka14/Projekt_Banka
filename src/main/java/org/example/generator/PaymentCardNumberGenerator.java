package org.example.generator;

public class PaymentCardNumberGenerator {


    public String generatePaymentCardNumber() {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i < 17; i++){

            int randomNum = (int)(Math.random() * 10);
            stringBuilder.append(randomNum);
            if(i % 4 == 0){
                stringBuilder.append(" ");
            }

        }
        return stringBuilder.toString();
    }
}
