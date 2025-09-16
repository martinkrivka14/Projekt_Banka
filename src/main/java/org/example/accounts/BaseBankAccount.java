package org.example.accounts;

import org.example.customer.Customer;

public class BaseBankAccount {

   private String uuid;

   private String bankAccountNumber;

   private Customer customer;

   private Double balance;

   public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, Double balance) {
       this.uuid = uuid;
       this.bankAccountNumber = bankAccountNumber;
       this.customer = customer;
       this.balance = balance;
   }

   public void addBalance(Double balance) {
       this.balance += balance;
   }

   public void subratedBalance(Double balance) throws IllegalArgumentException {
       double subractBalance = this.balance - balance;

       if(subractBalance < 0) {
           throw new IllegalArgumentException();
       } else if(subractBalance > 0) {
           this.balance = subractBalance;
       }

   }
   public String getUuid() {
       return uuid;
   }

   public String getBankAccountNumber() {
       return bankAccountNumber;
   }

   public Customer getCustomer() {
       return customer;
   }

   public Double getBalance() {
       return balance;
   }


}
