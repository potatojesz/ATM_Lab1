package com.tklimczak.lab1.service;

import java.math.BigDecimal;

import com.tklimczak.lab1.State;
import com.tklimczak.lab1.exception.NotEnoughBalanceException;

public class ATMAdminService {
    private final State state = State.getInstance();
  
    public void withdrawMoney(BigDecimal amount) throws Exception {
        try {
            state.atm.withdraw(amount);
        } catch(NotEnoughBalanceException ex) {
            System.out.println("There is not enough balance in ATM");
            throw ex;
        }
    }
    
    public void addMoney(BigDecimal amount) {
        state.atm.add(amount);
    }
}
