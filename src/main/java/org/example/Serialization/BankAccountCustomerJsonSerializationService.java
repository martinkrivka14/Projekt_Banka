package org.example.Serialization;

import com.google.gson.Gson;
import org.example.customer.Customer;

public class BankAccountCustomerJsonSerializationService implements Serialization{


    Gson gson = new Gson();
    BankAccountCustomerSerializationFactory bankAccountCustomerSerializationFactory = new BankAccountCustomerSerializationFactory();

    @Override
    public String serialization(Object obj) {

        if (!(obj instanceof Customer)) {
            throw new RuntimeException("Illegal type for serialization");
        }
        BankAccountCustomerSerialization bankAccountCustomerSerialization = bankAccountCustomerSerializationFactory.createBankAccountCustomerSerialization((Customer) obj);

        return gson.toJson(bankAccountCustomerSerialization);
    }

    @Override
    public Object deserialization(String str) {
        return gson.fromJson(str,  Customer.class);
    }
}
