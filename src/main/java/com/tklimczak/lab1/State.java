package com.tklimczak.lab1;

import java.math.BigDecimal;
import java.util.List;

import com.tklimczak.lab1.models.ATM;
import com.tklimczak.lab1.models.Account;
import com.tklimczak.lab1.models.Bank;

import java.util.ArrayList;
import java.util.Collections;

public class State {
    private static State instance = null;
    public final Bank bank;
    public final ATM atm;

    private State() 
    { 
        bank = new Bank();
        atm = new ATM();
        atm.setBalance(new BigDecimal("10000000000000"));
        List<Account> accounts = Collections.synchronizedList(new ArrayList<Account>(3));;
        accounts.add(new Account("123456", new BigDecimal("1000000000")));
        accounts.add(new Account("555555", new BigDecimal("2350030000")));
        accounts.add(new Account("111111", new BigDecimal("1231100000")));
        bank.setAccounts(accounts);
    } 
  
    public static State getInstance() 
    { 
        if (instance == null) 
            instance = new State(); 
  
        return instance; 
    } 
}
