package org.example.generator;
import java.time.LocalDate;

public class PaymentCardExpirationGenerator {


    public String generateExpirationDate(){

        StringBuilder stringBuilder = new StringBuilder();

        LocalDate date = LocalDate.now();

        if(date.getMonthValue() < 10){
            stringBuilder.append("0");
        }
        stringBuilder.append(date.getMonthValue()).append("/");

        int year = date.getYear()+5;
        String slicedYear = String.valueOf(year).substring(2);
        stringBuilder.append(slicedYear);

        return stringBuilder.toString();
    }
}
