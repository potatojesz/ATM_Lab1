package com.tklimczak.lab1.models;

import java.math.BigDecimal;

import com.tklimczak.lab1.exception.NotEnoughBalanceException;

public class Account {
    private BigDecimal balance;
    private String cardNumber;

    public Account(String cardNumber, BigDecimal balance) {
        this.balance = balance;
        this.cardNumber = cardNumber;
    }
   
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
 
    public void withdraw(BigDecimal amount) throws Exception {
        if(amount.compareTo(balance) < 0) {
            balance = balance.subtract(amount);
        } else {
            throw new NotEnoughBalanceException();
        }
    }
    public void add(BigDecimal amount) {
    	balance = balance.add(amount);
    }
}
