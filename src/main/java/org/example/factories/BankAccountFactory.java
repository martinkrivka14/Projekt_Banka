package org.example.factories;

import jakarta.inject.Inject;
import org.example.History.AccountTransaction;
import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.cards.PaymentCard;
import org.example.customer.Customer;
import org.example.generator.BankAccountNumberGenerator;
import org.example.school.School;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class BankAccountFactory {

    private final BankAccountNumberGenerator bankAccountNumberGenerator;

    @Inject
    public BankAccountFactory(BankAccountNumberGenerator bankAccountNumberGenerator){
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    public BankAccount createBaseBankAccount(String uuid, Customer customer, Double balance, ArrayList<PaymentCard> paymentCards) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();
        return new BankAccount(uuid,accountNumber,customer,balance,paymentCards);
    }

    public SaveAccount createSaveBankAccount(String uuid, Customer customer, Double balance, float interestRate, LocalDate openingDate, LocalDateTime lastInterestDate, ArrayList<AccountTransaction> accountTransactions) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new SaveAccount(uuid,accountNumber,customer,balance,interestRate, openingDate,lastInterestDate, accountTransactions);
    }

    public StudentAccount createStudentAccount(String uuid, Customer customer, Double balance, School school, ArrayList<PaymentCard> paymentCards) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentAccount(uuid,accountNumber,customer,balance,school, paymentCards);
    }

}
