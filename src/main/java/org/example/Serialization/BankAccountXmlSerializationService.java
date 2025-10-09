package org.example.Serialization;

import org.example.customer.Customer;
import com.thoughtworks.xstream.XStream;

public class BankAccountXmlSerializationService implements Serialization {


    XStream xStream = new XStream();
    BankAccountCustomerSerializationFactory bankAccountCustomerSerializationFactory = new BankAccountCustomerSerializationFactory();
    @Override
    public String serialization(Object obj) {

        if (!(obj instanceof Customer)) {
            throw new RuntimeException("Illegal type for serialization");
        }

        BankAccountCustomerSerialization bankAccountCustomerSerialization = bankAccountCustomerSerializationFactory.createBankAccountCustomerSerialization((Customer) obj);

        return xStream.toXML(bankAccountCustomerSerialization);
    }

    @Override
    public Object deserialization(String str) {

        return xStream.fromXML(str);
    }
}
