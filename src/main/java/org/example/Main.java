package org.example;


import org.example.Serialization.BankAccountCustomerJsonSerializationService;
import org.example.Serialization.BankAccountXmlSerializationService;
import org.example.accounts.BankAccount;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.cards.PaymentCard;
import org.example.customer.Customer;
import org.example.factories.BankAccountFactory;
import org.example.factories.CustomerFactory;
import org.example.factories.PaymentCardFactory;
import org.example.school.School;
import org.example.services.BankAccountService;
import org.example.services.PaymentCardService;

import java.util.ArrayList;
import java.util.HashMap;

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


            //factory of payment card

            PaymentCardFactory paymentCardFactory = new PaymentCardFactory();

            //customer name
            String customerName = "Frantisek Jakubec";
            PaymentCard paymentCard = paymentCardFactory.createPaymentCardFactory(customerName);
            PaymentCard paymentCard1 = paymentCardFactory.createPaymentCardFactory(customerName);
            PaymentCard paymentCard2 = paymentCardFactory.createPaymentCardFactory(customerName);
            PaymentCard paymentCard3 = paymentCardFactory.createPaymentCardFactory(customerName);
            System.out.println("Info about payment card");
            paymentCard.paymentCardInfo();




            ArrayList<BankAccountWithPaymentCards> bankAccountsList = new ArrayList<>();
            HashMap<String,String> bankVCard = new HashMap<>(); // creating a map for a link from card to account





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

            BankAccountWithPaymentCards accounts = bankAccountFactory.createBaseBankAccount("u123", customer, 0.0,paymentCard);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());
            //creating a list of a bank account numbers
            bankAccountsList.add(accounts); //adding a bank account number to a list


            BankAccountWithPaymentCards BankAccount = bankAccountFactory.createBaseBankAccount("u123", customer, 0.0,paymentCard1);
            bankAccountsList.add(BankAccount); //adding a bank account number to a list

            BaseBankAccount SaveAccount = bankAccountFactory.createSaveBankAccount("u456", customer, 0.0, 0.0F);

            BankAccountWithPaymentCards StudentAccount = bankAccountFactory.createStudentAccount("t325", customer,0.0,0.0F, school,paymentCard2);
            bankAccountsList.add(StudentAccount); //adding a bank account number to a list


            System.out.println("Cisla uctu");
            System.out.println(BankAccount.getUuid() + ": " + BankAccount.getBalance() + ": " + BankAccount.getBankAccountNumber());
            System.out.println(SaveAccount.getUuid() + ": " + SaveAccount.getBalance() + ": " + SaveAccount.getBankAccountNumber());
            System.out.println(StudentAccount.getUuid() + ": " + StudentAccount.getBalance() + ": " + StudentAccount.getBankAccountNumber());

            System.out.println("Payment card info");
            accounts.getPaymentCard().paymentCardInfo();

            PaymentCardService paymentCardService = new PaymentCardService();

            System.out.println("Add card to a bank account");
            //adding card to a hash map
            paymentCardService.addToBankAccount(paymentCard,accounts,bankVCard);
            //found a bank account
            paymentCardService.getBankAccountByPaymentCardNumber(paymentCard,bankVCard);

            //getting a bank account and their balance
            paymentCardService.getBankAccountBalanceByPaymentCardNumber(paymentCard,bankVCard,bankAccountsList);
            // adding some money
            bankAccountServiceFactory.addBalance(accounts, 5000.00);
            //repeating
            paymentCardService.getBankAccountBalanceByPaymentCardNumber(paymentCard,bankVCard,bankAccountsList);


            //adding money to a card

            paymentCardService.addBalanceToBankAccount(paymentCard,bankVCard,bankAccountsList,5000.00);

            paymentCardService.getBankAccountBalanceByPaymentCardNumber(paymentCard,bankVCard,bankAccountsList);




            bankAccountServiceFactory.allCardsForThisBankAccount(accounts,bankVCard);

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