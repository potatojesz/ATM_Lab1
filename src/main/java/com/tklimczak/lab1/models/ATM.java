package com.tklimczak.lab1.models;

import java.math.BigDecimal;

import com.tklimczak.lab1.exception.NotEnoughBalanceException;

public class ATM {
    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
 
    public void add(BigDecimal amount) {
        balance = balance.add(amount);
    }
   
    public void withdraw(BigDecimal amount) throws Exception {
        if(amount.compareTo(balance) < 0) {
            balance = balance.subtract(amount);
        } else {
            throw new NotEnoughBalanceException();
        }
    }
}
