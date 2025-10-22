package org.example.Serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.customer.Customer;

public class BankAccountCustomerXmlSerializationService implements Serialization{


    private final XmlMapper xmlMapper = new XmlMapper();

    {
        // Enable indentation for the XML output for better readability.
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    BankAccountCustomerSerializationFactory bankAccountCustomerSerializationFactory = new BankAccountCustomerSerializationFactory();

    @Override
    public String serialization(Object obj) {

        if (!(obj instanceof Customer)) {
            throw new RuntimeException("Illegal type for serialization");
        }

        BankAccountCustomerSerialization bankAccountCustomerSerialization = bankAccountCustomerSerializationFactory.createBankAccountCustomerSerialization((Customer) obj);

        try {
            // from XML object to string
            return xmlMapper.writeValueAsString(bankAccountCustomerSerialization);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error in XML serialization", e);
        }
    }

    @Override
    public Object deserialization(String str) {

        try {
            //from XML string to object
            // have to told jackson what type of object we want
            return xmlMapper.readValue(str, BankAccountCustomerSerialization.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error in Xml Deserialization", e);
        }
    }

}
