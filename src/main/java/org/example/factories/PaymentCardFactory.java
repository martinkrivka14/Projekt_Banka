package org.example.factories;

import org.example.cards.PaymentCard;
import org.example.generator.PaymentCardCvvGenerator;
import org.example.generator.PaymentCardExpirationGenerator;
import org.example.generator.PaymentCardNumberGenerator;

public class PaymentCardFactory {

    PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();
    PaymentCardExpirationGenerator paymentCardExpirationGenerator = new PaymentCardExpirationGenerator();
    
    public PaymentCard createPaymentCardFactory(String customer) {

        String generatedCardNumber = paymentCardNumberGenerator.generatePaymentCardNumber();
        String generatedCvvNumber = paymentCardCvvGenerator.generatePaymentCardCvv();
        String generatedExpiration = paymentCardExpirationGenerator.generateExpirationDate();

        return new PaymentCard(generatedCardNumber,customer,generatedExpiration,generatedCvvNumber);
    }
}
