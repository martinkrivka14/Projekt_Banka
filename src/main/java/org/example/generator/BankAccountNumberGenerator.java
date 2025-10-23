package org.example.generator;

public class BankAccountNumberGenerator {

    public String generateBankAccountNumber() {
        StringBuilder generatedNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomNum = (int)(Math.random() * 10);
            generatedNumber.append(randomNum);
        }
        return generatedNumber.toString();
    }
}
