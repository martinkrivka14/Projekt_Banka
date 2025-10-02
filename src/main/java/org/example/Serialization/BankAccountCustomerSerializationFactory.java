package org.example.Serialization;

import org.example.customer.Customer;

public class BankAccountCustomerSerializationFactory {

    public BankAccountCustomerSerialization createBankAccountCustomerSerialization(Customer customer) {

        BankAccountCustomerSerialization bankAccountOwnerSerialization = new BankAccountCustomerSerialization();

        bankAccountOwnerSerialization.uuid = customer.getUuid();
        bankAccountOwnerSerialization.firstName = customer.getFirstName();
        bankAccountOwnerSerialization.lastName = customer.getLastName();

        return bankAccountOwnerSerialization;
    }
}
