package org.example.generators;

public class BankAccountNumberGenerator {

    public String bankAccountNumber;
    public BankAccountNumberGenerator() {
        this.bankAccountNumber = generateBankAccountNumber();
    }

    public String generateBankAccountNumber() {
        StringBuilder generatedNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomNum = (int)(Math.random() * 10);
            generatedNumber.append(randomNum);
        }
        return generatedNumber.toString();
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
}
