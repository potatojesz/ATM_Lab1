package com.tklimczak.lab1.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.tklimczak.lab1.exception.AccountWithCardNumberDoesntExistException;

public class Bank {
    private List<Account> accounts = new ArrayList<>();

    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
   
    public Account getAccount(String cardNumber) throws Exception {
        if(accounts.size() > 0) {
            Optional<Account> result = accounts.stream()
                   .filter(m->m.getCardNumber().equals(cardNumber))
                   .findFirst();
            if(result.isPresent()) {
                return result.get();
            }
        }
        throw new AccountWithCardNumberDoesntExistException();
    }
}
