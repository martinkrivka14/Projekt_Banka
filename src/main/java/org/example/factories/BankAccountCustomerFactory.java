package org.example.factories;

import org.example.accounts.BaseBankAccount;
import org.example.customer.Customer;

public class BankAccountCustomerFactory {


    public Customer createCustomer(String uuid, String firstName, String lastName){

        return  new Customer(uuid, firstName, lastName);
    }
}
