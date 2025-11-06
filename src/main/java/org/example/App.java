package org.example;


import jakarta.inject.Inject;
import org.example.Serialization.BankAccountCustomerJsonSerializationService;
import org.example.Serialization.BankAccountCustomerXmlSerializationService;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveAccount;
import org.example.accounts.StudentAccount;
import org.example.cards.PaymentCard;
import org.example.customer.Customer;
import org.example.facades.InterestRunnerFacade;
import org.example.factories.BankAccountFactory;
import org.example.factories.CustomerFactory;
import org.example.factories.PaymentCardFactory;
import org.example.school.School;
import org.example.services.BankAccountService;
import org.example.services.InterestCronService;
import org.example.services.PaymentCardService;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {



    @Inject
    private CustomerFactory customerFactory;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private BankAccountService bankAccountService;

    @Inject
    private PaymentCardFactory paymentCardFactory;

    @Inject
    private PaymentCardService paymentCardService;

    @Inject
    private InterestRunnerFacade  interestRunnerFacade;

    @Inject
    private InterestCronService interestCronService;

    private final ArrayList<BaseBankAccount> accounts = new ArrayList<>();



    public void run() {
        try {

            //implementing customer trough factory
            Customer customer = customerFactory.createCustomer("c123","Martin","Krivka");


            //customer name
            String customerName = "Frantisek Jakubec";
            PaymentCard paymentCard = paymentCardFactory.createPaymentCardFactory(customerName);
            PaymentCard paymentCard1 = paymentCardFactory.createPaymentCardFactory(customerName);
            System.out.println("Info about payment card");
            paymentCard.getPaymentCardInfo();


            ArrayList<BaseBankAccount> bankAccountsList = new ArrayList<>();
            HashMap<String,String> bankVCard = new HashMap<>(); // creating a map for a link from card to account

            ArrayList<PaymentCard> paymentCards = new ArrayList<>();
            ArrayList<PaymentCard> paymentCardsClassic = new ArrayList<>();
            ArrayList<PaymentCard> paymentCardsStudent = new ArrayList<>();

            BankAccountCustomerJsonSerializationService serviceJson = new BankAccountCustomerJsonSerializationService();
            String json = serviceJson.serialization(customer);
            System.out.println("Serialized JSON:");
            System.out.println(json);


            BankAccountCustomerXmlSerializationService serviceXml = new BankAccountCustomerXmlSerializationService();
            String Xml = serviceXml.serialization(customer);
            System.out.println("Serialized XML:");
            System.out.println(Xml);

            /*Customer deserialized = (Customer) service.deserialization(json);
            System.out.println("\nDeserialized object:");
            System.out.println(deserialized);*/



            School school = new School("Delta", "Pardubice 1", "delta@gmail.com","+420 777 568 562", 200.0F);
            System.out.println(customer.getUuid() + ": " + customer.getFirstName() + ": " + customer.getLastName());

            BaseBankAccount accounts = bankAccountFactory.createBaseBankAccount("u123", customer, 0.0,paymentCards);
            System.out.println(accounts.getUuid() + ": " + accounts.getBalance());
            //creating a list of a bank account numbers
            bankAccountsList.add(accounts); //adding a bank account number to a list


            BaseBankAccount BankAccount = bankAccountFactory.createBaseBankAccount("u123", customer, 0.0,paymentCardsClassic);
            bankAccountsList.add(BankAccount); //adding a bank account number to a list

            BaseBankAccount SaveAccount = bankAccountFactory.createSaveBankAccount("u456", customer, 0.0, 5.0F, LocalDate.now(), LocalDateTime.now());
            bankAccountsList.add(SaveAccount);

            StudentAccount StudentAccount = bankAccountFactory.createStudentAccount("t325", customer,0.0, school,paymentCardsStudent);
            bankAccountsList.add(StudentAccount); //adding a bank account number to a list


            System.out.println("Cisla uctu");
            System.out.println(BankAccount.getUuid() + ": " + BankAccount.getBalance() + ": " + BankAccount.getBankAccountNumber());
            System.out.println(SaveAccount.getUuid() + ": " + SaveAccount.getBalance() + ": " + SaveAccount.getBankAccountNumber());
            System.out.println(StudentAccount.getUuid() + ": " + StudentAccount.getBalance() + ": " + StudentAccount.getBankAccountNumber());

            /*
            System.out.println("Payment card info");
            accounts.getPaymentCard().paymentCardInfo();*/

            System.out.println("Add card to a bank account");
            //adding card to a hash map

            paymentCardService.addBankAccountToCard(paymentCard,accounts, bankVCard);
            //adding card to an account
            bankAccountService.addCardToBankAccount(accounts,paymentCard1,bankVCard);
            //removing card from account
            //bankAccountService.removeCardFromBankAccount(accounts,paymentCard,bankVCard);

            //looking for a bank account
            paymentCardService.getBankAccountByPaymentCardNumber(paymentCard,bankVCard);

            //getting a bank account and their balance
            paymentCardService.getBankAccountBalanceByPaymentCardNumber(paymentCard,bankVCard,bankAccountsList);
            // adding some money
            bankAccountService.addBalance(accounts, 5000.00);
            //repeating
            paymentCardService.getBankAccountBalanceByPaymentCardNumber(paymentCard1,bankVCard,bankAccountsList);


            //adding money to a card
            paymentCardService.addBalanceToBankAccount(paymentCard,bankVCard,bankAccountsList,5000.00);

            paymentCardService.getBankAccountBalanceByPaymentCardNumber(paymentCard,bankVCard,bankAccountsList);


            //changing pin
            paymentCardService.changePin(paymentCard);

            //subrating money from a card
            paymentCardService.subtractBalanceFromBankAccount(paymentCard,bankVCard,bankAccountsList,300.00);


            bankAccountService.allCardsForThisBankAccount(accounts,bankVCard);

            bankAccountService.addBalance(BankAccount,500.0);
            System.out.println("Basic bank account balance: " + BankAccount.getBankAccountNumber() + ": " + BankAccount.getBalance());

            /*
            bankAccountService.subractedBalance(BankAccount,1200.0);
            System.out.println("Basic bank account balance: " +BankAccount.getBankAccountNumber() + ": " + BankAccount.getBalance());


            bankAccountService.addBalance(SaveAccount, 100000000.00); //catch a limit of 10 000 euros
            */


            //depositing money to save account
            bankAccountService.addBalance(SaveAccount,1000.0);



            //starting Cron Service for rates
            interestCronService.start(bankAccountsList);


            Scanner scanner = new Scanner(System.in);
            scanner.nextLine(); // waiting for enter to end cron, only for testing
            interestCronService.stop();
            scanner.close();

            //checking money from interests
            System.out.println(SaveAccount.getBalance());

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
