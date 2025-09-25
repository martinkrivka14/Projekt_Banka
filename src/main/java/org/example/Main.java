package org.example;

import org.example.factories.BankAccountFactory;
import org.example.factories.BankAccountService;
//import org.example.generators.BankAccountNumberGenerator;
import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.customer.Customer;
import org.example.school.School;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{

            BankAccountFactory bankAccountFactory = new BankAccountFactory();

            BankAccountService bankAccountServiceFactory = new BankAccountService();

            Customer customer = new Customer("c123","Martin","Krivka");
            School school = new School("Delta", "Pardubice 1", "delta@gmail.com","+420 777 568 562", 200.0F);
            System.out.println(customer.getUuid() + ": " + customer.getFirstName() + ": " + customer.getLastName());
            BaseBankAccount accounts =bankAccountFactory.createBaseBankAccount("u123", customer, 0.0);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());

            BaseBankAccount BankAccount = bankAccountFactory.createBaseBankAccount("u123", customer, 0.0);
            BaseBankAccount SaveAccount = bankAccountFactory.createSaveBankAccount("u456", customer, 0.0, 0.0F);
            BaseBankAccount StudentAccount = bankAccountFactory.createStudentAccount("t325", customer,0.0,0.0F, school);


            System.out.println("Cisla uctu");
            System.out.println(BankAccount.getUuid() + ": " + BankAccount.getBalance() + ": " + BankAccount.getBankAccountNumber());
            System.out.println(SaveAccount.getUuid() + ": " + SaveAccount.getBalance() + ": " + SaveAccount.getBankAccountNumber());
            System.out.println(StudentAccount.getUuid() + ": " + StudentAccount.getBalance() + ": " + StudentAccount.getBankAccountNumber());


            bankAccountServiceFactory.addBalance(accounts,500.0);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());

            bankAccountServiceFactory.subractedBalance(accounts,200.0);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance() + ": " + accounts.getBankAccountNumber());

           System.out.println("TEST BANK ACCOUNT");
           BaseBankAccount BankAccount1 = testBankAccount(customer);

           System.out.println(BankAccount1 instanceof BankAccount ? "Bank" : "Save");

           System.out.println("TEST SAVE ACCOUNT");
           BaseBankAccount BankAccount2 = testSaveAccount(customer);

           System.out.println(BankAccount2 instanceof SaveAccount ? "Save" : "Bank");

           if(BankAccount2 instanceof SaveAccount){
               float interestRate = ((SaveAccount)BankAccount2).getInterestRate();
               System.out.println("Interest Rate is " + interestRate);
           }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static BaseBankAccount testBankAccount (Customer customer){
        BankAccount bankAccount = new BankAccount("u123", "123456789", customer, 0.0);
        try{
            System.out.println(bankAccount.getUuid() + ": " + bankAccount.getBalance());

            BankAccountService bankAccountServiceFactory = new BankAccountService();
            bankAccountServiceFactory.addBalance(bankAccount,500.0);
            System.out.println(bankAccount.getUuid() + ": " + bankAccount.getBalance());

            bankAccountServiceFactory.subractedBalance(bankAccount,200.0);
            System.out.println(bankAccount.getUuid() + ": " + bankAccount.getBalance());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return bankAccount;
    }

    private static BaseBankAccount testSaveAccount (Customer customer){
        SaveAccount saveAccount = new SaveAccount("u123", "123456780", customer, 0.0,0.0F);
        try{
            System.out.println(saveAccount.getUuid() + ": " + saveAccount.getBalance());

            BankAccountService bankAccountServiceFactory = new BankAccountService();
            bankAccountServiceFactory.addBalance(saveAccount,500.0);
            System.out.println(saveAccount.getUuid() + ": " + saveAccount.getBalance());

            bankAccountServiceFactory.subractedBalance(saveAccount,200.0);
            System.out.println(saveAccount.getUuid() + ": " + saveAccount.getBalance());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return saveAccount;
    }



}