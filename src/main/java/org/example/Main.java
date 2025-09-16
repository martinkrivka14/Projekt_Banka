package org.example;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.customer.Customer;
import org.example.school.School;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            Customer customer = new Customer("c123","Martin","Krivka");
            School school = new School("Delta", "Pardubice 1", "delta@gmail.com","+420 777 568 562", 200.0F);
            System.out.println(customer.getUuid() + ": " + customer.getFirstName() + ": " + customer.getLastName());
            BaseBankAccount accounts = new BaseBankAccount("u123", "123456789", customer, 0.0);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());

            BaseBankAccount BankAccount = new BankAccount("u123", "123456789", customer, 0.0);
            BaseBankAccount SaveAccount = new SaveAccount("u456", "123456780", customer, 0.0, 0.0F);
            BaseBankAccount StudentAccount = new StudentAccount("t325","987654321", customer,0.0,0.0F, school);

            accounts.addBalance(500.0);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());

            accounts.subratedBalance(200.0);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());

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

            bankAccount.addBalance(500.0);
            System.out.println(bankAccount.getUuid() + ": " + bankAccount.getBalance());

            bankAccount.subratedBalance(200.0);
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

            saveAccount.addBalance(500.0);
            System.out.println(saveAccount.getUuid() + ": " + saveAccount.getBalance());

            saveAccount.subratedBalance(200.0);
            System.out.println(saveAccount.getUuid() + ": " + saveAccount.getBalance());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return saveAccount;
    }
}