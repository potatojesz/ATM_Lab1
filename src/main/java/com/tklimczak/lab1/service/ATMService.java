package com.tklimczak.lab1.service;

import java.math.BigDecimal;

import com.tklimczak.lab1.exception.AccountWithCardNumberDoesntExistException;
import com.tklimczak.lab1.exception.NotEnoughBalanceException;
import com.tklimczak.lab1.models.Account;

public class ATMService {
    private final com.tklimczak.lab1.State state = com.tklimczak.lab1.State.getInstance();
    private final transient ATMAdminService adminService = new ATMAdminService();
   
    public void withdrawMoney(String cardNumber, BigDecimal amount) throws Exception {
        try {
            Account account = state.bank.getAccount(cardNumber);
            adminService.withdrawMoney(amount);
            account.withdraw(amount);
        } catch(AccountWithCardNumberDoesntExistException ex) {
            System.out.println("There is no account with cardNumber: " + cardNumber);
            throw ex;
        } catch(NotEnoughBalanceException ex) {
            System.out.println("There is not enough balance on account with cardNumber: " + cardNumber);
            throw ex;
        }
    }
    
    public void addMoney(String cardNumber, BigDecimal amount) throws Exception {
        try {
            Account account = state.bank.getAccount(cardNumber);
            adminService.addMoney(amount);
            account.add(amount);
        } catch(AccountWithCardNumberDoesntExistException ex) {
            System.out.println("There is no account with cardNumber: " + cardNumber);
            throw ex;
        }
    }
   
    public BigDecimal getBalance(String cardNumber) throws Exception {
        try {
            Account account = state.bank.getAccount(cardNumber);
            return account.getBalance();
        } catch(AccountWithCardNumberDoesntExistException ex) {
            System.out.println("There is no account with cardNumber: " + cardNumber);
            throw ex;
        }
    }
}
