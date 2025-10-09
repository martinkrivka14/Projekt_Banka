package org.example;


import org.example.Serialization.BankAccountCustomerJsonSerializationService;
import org.example.Serialization.BankAccountXmlSerializationService;
import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.customer.Customer;
import org.example.factories.BankAccountFactory;
import org.example.factories.CustomerFactory;
import org.example.school.School;
import org.example.services.BankAccountService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{


            //factory for bank accounts
            BankAccountFactory bankAccountFactory = new BankAccountFactory();

            CustomerFactory customerFactory = new CustomerFactory();

            //service for bank accounts factories
            BankAccountService bankAccountServiceFactory = new BankAccountService();



            //implementing customer trough factory
            Customer customer = customerFactory.createCustomer("c123","Martin","Krivka");

            BankAccountCustomerJsonSerializationService serviceJson = new BankAccountCustomerJsonSerializationService();
            String json = serviceJson.serialization(customer);
            System.out.println("Serialized JSON:");
            System.out.println(json);


            BankAccountXmlSerializationService serviceXml = new BankAccountXmlSerializationService();
            String Xml = serviceXml.serialization(customer);
            System.out.println("Serialized XML:");
            System.out.println(Xml);

            /*Customer deserialized = (Customer) service.deserialization(json);
            System.out.println("\nDeserialized object:");
            System.out.println(deserialized);*/



            School school = new School("Delta", "Pardubice 1", "delta@gmail.com","+420 777 568 562", 200.0F);
            System.out.println(customer.getUuid() + ": " + customer.getFirstName() + ": " + customer.getLastName());
            BaseBankAccount accounts = bankAccountFactory.createBaseBankAccount("u123", customer, 0.0);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());

            BaseBankAccount BankAccount = bankAccountFactory.createBaseBankAccount("u123", customer, 0.0);
            BaseBankAccount SaveAccount = bankAccountFactory.createSaveBankAccount("u456", customer, 0.0, 0.0F);
            BaseBankAccount StudentAccount = bankAccountFactory.createStudentAccount("t325", customer,0.0,0.0F, school);


            System.out.println("Cisla uctu");
            System.out.println(BankAccount.getUuid() + ": " + BankAccount.getBalance() + ": " + BankAccount.getBankAccountNumber());
            System.out.println(SaveAccount.getUuid() + ": " + SaveAccount.getBalance() + ": " + SaveAccount.getBankAccountNumber());
            System.out.println(StudentAccount.getUuid() + ": " + StudentAccount.getBalance() + ": " + StudentAccount.getBankAccountNumber());


            bankAccountServiceFactory.addBalance(BankAccount,500.0);
            System.out.println("Basic bank account balance: " + BankAccount.getUuid() + ": " + BankAccount.getBalance());

            bankAccountServiceFactory.subractedBalance(BankAccount,200.0);
            System.out.println("Basic bank account balance: " +BankAccount.getUuid() + ": " + BankAccount.getBalance() + ": " + BankAccount.getBankAccountNumber());


            bankAccountServiceFactory.addBalance(SaveAccount, 100000000.00); //catch a limit of 10 000 euros


        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }


}