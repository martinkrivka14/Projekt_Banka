package org.example.factories;

import org.example.cards.PaymentCard;
import org.example.generator.PaymentCardCvvGenerator;
import org.example.generator.PaymentCardExpirationGenerator;
import org.example.generator.PaymentCardNumberGenerator;
import org.example.generator.PaymentCardPinGenerator;

public class PaymentCardFactory {

    PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();
    PaymentCardExpirationGenerator paymentCardExpirationGenerator = new PaymentCardExpirationGenerator();
    PaymentCardPinGenerator paymentCardPinGenerator = new PaymentCardPinGenerator();

    public PaymentCard createPaymentCardFactory(String customer) {

        String generatedCardNumber = paymentCardNumberGenerator.generatePaymentCardNumber();
        String generatedCvvNumber = paymentCardCvvGenerator.generatePaymentCardCvv();
        String generatedExpiration = paymentCardExpirationGenerator.generateExpirationDate();
        Integer generatedPin = paymentCardPinGenerator.generatePaymentCardPin();

        return new PaymentCard(generatedCardNumber,customer,generatedExpiration,generatedCvvNumber, generatedPin);
    }


}