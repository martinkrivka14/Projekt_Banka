package org.example.factories;

import jakarta.inject.Inject;
import org.example.cards.PaymentCard;
import org.example.generator.PaymentCardCvvGenerator;
import org.example.generator.PaymentCardExpirationGenerator;
import org.example.generator.PaymentCardNumberGenerator;
import org.example.generator.PaymentCardPinGenerator;

public class PaymentCardFactory {

    private PaymentCardNumberGenerator paymentCardNumberGenerator;
    private PaymentCardCvvGenerator paymentCardCvvGenerator;
    private PaymentCardExpirationGenerator paymentCardExpirationGenerator;
    private PaymentCardPinGenerator paymentCardPinGenerator;


    @Inject
    public PaymentCardFactory(PaymentCardNumberGenerator paymentCardNumberGenerator,
                              PaymentCardCvvGenerator paymentCardCvvGenerator,
                              PaymentCardExpirationGenerator paymentCardExpirationGenerator,
                              PaymentCardPinGenerator paymentCardPinGenerator){
        this.paymentCardNumberGenerator = paymentCardNumberGenerator;
        this.paymentCardCvvGenerator = paymentCardCvvGenerator;
        this.paymentCardExpirationGenerator = paymentCardExpirationGenerator;
        this.paymentCardPinGenerator = paymentCardPinGenerator;
    }



    public PaymentCard createPaymentCardFactory(String customer) {

        String generatedCardNumber = paymentCardNumberGenerator.generatePaymentCardNumber();
        String generatedCvvNumber = paymentCardCvvGenerator.generatePaymentCardCvv();
        String generatedExpiration = paymentCardExpirationGenerator.generateExpirationDate();
        Integer generatedPin = paymentCardPinGenerator.generatePaymentCardPin();

        return new PaymentCard(generatedCardNumber,customer,generatedExpiration,generatedCvvNumber, generatedPin);
    }


}