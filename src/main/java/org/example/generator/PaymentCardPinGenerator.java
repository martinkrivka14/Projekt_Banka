package org.example.generator;

public class PaymentCardPinGenerator {


    public Integer generatePaymentCardPin(){

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++){
            int randomNum = (int)(Math.random() * 10);
            stringBuilder.append(randomNum);
        }

        String value = stringBuilder.toString();
        Integer intValue = Integer.parseInt(value);

        return intValue;
    }
}
