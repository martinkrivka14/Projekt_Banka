package org.example.factories;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.customer.Customer;
import org.example.generators.BankAccountNumberGenerator;
import org.example.school.School;

public class BankAccountFactory {

    BankAccountNumberGenerator bankAccountNumberGenerator = new BankAccountNumberGenerator();

    public BaseBankAccount createBaseBankAccount(String uuid, String bankAccountNumber, Customer customer, Double balance){
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new BaseBankAccount(uuid,bankAccountNumber,customer,balance);
    }

    public SaveAccount createBaseBankAccount(String uuid, String bankAccountNumber, Customer customer, Double balance,float interestRate){
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new SaveAccount(uuid,bankAccountNumber,customer,balance,interestRate);
    }

    public StudentAccount createStudentAccount(String uuid, String bankAccountNumber, Customer customer, Double balance, float interestRate, School school){
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentAccount(uuid,bankAccountNumber,customer,balance,interestRate,school);
    }

}
