package org.example.factories;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.cards.PaymentCard;
import org.example.customer.Customer;
import org.example.generator.BankAccountNumberGenerator;
import org.example.school.School;

import java.util.ArrayList;


public class BankAccountFactory {

    BankAccountNumberGenerator bankAccountNumberGenerator = new BankAccountNumberGenerator();

    public BankAccount createBaseBankAccount(String uuid, Customer customer, Double balance, ArrayList<PaymentCard> paymentCards) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();
        return new BankAccount(uuid,accountNumber,customer,balance,paymentCards);
    }

    public SaveAccount createSaveBankAccount(String uuid, Customer customer, Double balance,float interestRate){
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new SaveAccount(uuid,accountNumber,customer,balance,interestRate);
    }

    public StudentAccount createStudentAccount(String uuid, Customer customer, Double balance, float interestRate, School school, ArrayList<PaymentCard> paymentCards) {
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentAccount(uuid,accountNumber,customer,balance,interestRate,school, paymentCards);
    }


}
