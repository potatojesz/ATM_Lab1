package com.tklimczak.lab1.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.tklimczak.lab1.State;
import com.tklimczak.lab1.exception.AccountWithCardNumberDoesntExistException;
import com.tklimczak.lab1.exception.NotEnoughBalanceException;
import com.tklimczak.lab1.service.ATMService;

public class ATMServiceTest {

	private ATMService service;
	private static final String cardNumber = "123456";
	private static final String cardNumberWrong = "111";

	@Before
    public void setUp() {
		State.getInstance();
		service = new ATMService();
    }
	 
	@Test
	public void withdrawMoney() throws Exception {
		BigDecimal balanceStart = service.getBalance(cardNumber);
		service.withdrawMoney(cardNumber, BigDecimal.ONE);
		BigDecimal balanceEnd = service.getBalance(cardNumber);
		assertTrue(balanceEnd.compareTo(balanceStart) == -1);
		assertTrue(balanceEnd.compareTo(balanceStart.subtract(BigDecimal.ONE)) == 0);
	}

	@Test(expected = AccountWithCardNumberDoesntExistException.class)
	public void addMoneyWrongAccount() throws Exception {
		service.addMoney(cardNumberWrong, BigDecimal.ONE);
	}

	@Test(expected = AccountWithCardNumberDoesntExistException.class)
	public void withdrawMoneyWrongAccount() throws Exception {
		service.withdrawMoney(cardNumberWrong, BigDecimal.ONE);
	}
	
	@Test(expected = NotEnoughBalanceException.class)
	public void withdrawMoneyAmountExceeded() throws Exception {
		BigDecimal balance = service.getBalance(cardNumber);
		service.withdrawMoney(cardNumber, balance.add(BigDecimal.ONE));
	}

	@Test
	public void addMoney() throws Exception {
		BigDecimal balanceStart = service.getBalance(cardNumber);
		service.addMoney(cardNumber, BigDecimal.ONE);
		BigDecimal balanceEnd = service.getBalance(cardNumber);
		assertTrue(balanceEnd.compareTo(balanceStart) == 1);
		assertTrue(balanceEnd.compareTo(balanceStart.add(BigDecimal.ONE)) == 0);
	}

	@Test(expected = NullPointerException.class)
	public void addNullMoney() throws Exception {
		service.addMoney(cardNumber, null);
	}

	@Test
	public void getBalance() throws Exception {
		BigDecimal balance = service.getBalance(cardNumber);
		assertNotNull(balance);
	}
}
