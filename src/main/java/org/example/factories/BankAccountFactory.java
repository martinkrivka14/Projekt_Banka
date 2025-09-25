package org.example.factories;

import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.customer.Customer;
import org.example.generator.BankAccountNumberGenerator;
import org.example.school.School;



public class BankAccountFactory {

    BankAccountNumberGenerator bankAccountNumberGenerator = new BankAccountNumberGenerator();

    public BaseBankAccount createBaseBankAccount(String uuid, Customer customer, Double balance){
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new BaseBankAccount(uuid,accountNumber,customer,balance);
    }

    public SaveAccount createSaveBankAccount(String uuid, Customer customer, Double balance,float interestRate){
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new SaveAccount(uuid,accountNumber,customer,balance,interestRate);
    }

    public StudentAccount createStudentAccount(String uuid, Customer customer, Double balance, float interestRate, School school){
        String accountNumber = bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentAccount(uuid,accountNumber,customer,balance,interestRate,school);
    }

}
