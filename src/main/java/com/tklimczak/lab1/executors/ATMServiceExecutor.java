package com.tklimczak.lab1.executors;

import java.math.BigDecimal;

import com.tklimczak.lab1.service.ATMService;

public class ATMServiceExecutor extends Thread {
    private String threadNumber;
    private static String ACCOUNT_ONE = "123456";
    private static String ACCOUNT_TWO = "555555";
    private static String LOGGER = "%s account balance: %s at thread number: %s";
    
    public ATMServiceExecutor(String threadNumber) {
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                ATMService service = new ATMService();
                String log = "";
                synchronized(service) {
	                service.withdrawMoney(ACCOUNT_ONE, BigDecimal.ONE);
	                log = String.format(LOGGER, "First", service.getBalance(ACCOUNT_ONE), threadNumber);
                }
                System.out.println(log);
                Thread.sleep(20);
                synchronized(service) {
	                service.withdrawMoney(ACCOUNT_TWO, new BigDecimal("2"));
	                log = String.format(LOGGER, "Second", service.getBalance(ACCOUNT_TWO), threadNumber);
                }
                System.out.println(log);
                Thread.sleep(20);
            }
        } catch(Exception ex) {
            System.out.println("Something went wrong on thread: " + threadNumber);
            System.out.println(ex.getClass().toString());
        }
    }
}
