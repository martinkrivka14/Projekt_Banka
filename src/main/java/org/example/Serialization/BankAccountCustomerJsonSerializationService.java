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
        BankAccountCustomerSerialization bankAccountOwnerSerialization = bankAccountCustomerSerializationFactory.createBankAccountCustomerSerialization((Customer) obj);

        /*
          StringBuilder sb = new StringBuilder();
          sb.append("{");
          sb.append("\"uuid\":\"" + bankAccountOwnerSerialization.uuid + "\",");
          sb.append("\"firstName\":\"" + bankAccountOwnerSerialization.firstName + "\",");
          sb.append("\"lastName\":\"" + bankAccountOwnerSerialization.lastName + "\"");
          sb.append("}");
        */

        return gson.toJson(bankAccountOwnerSerialization);
    }

    @Override
    public Object deserialization(String str) {
        return gson.fromJson("",  Customer.class);
    }
}

