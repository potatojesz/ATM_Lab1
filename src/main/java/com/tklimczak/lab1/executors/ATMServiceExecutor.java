package com.tklimczak.lab1.executors;

import java.math.BigDecimal;

import com.tklimczak.lab1.service.ATMService;

public class ATMServiceExecutor extends Thread {
    private String threadNumber;

    public ATMServiceExecutor(String threadNumber) {
        this.threadNumber = threadNumber;
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                ATMService service = new ATMService();
                synchronized(service) {
	                service.withdrawMoney("123456", BigDecimal.ONE);
	                System.out.println(service.getBalance("123456") + "\nthread: " + threadNumber);
                }
                synchronized(service) {
	                Thread.sleep(500);
	                service.withdrawMoney("555555", new BigDecimal("2"));
	                System.out.println(service.getBalance("555555") + "\nthread: " + threadNumber);
                }
                Thread.sleep(500);
            }
        } catch(Exception ex) {
            System.out.println("Something went wrong on thread: " + threadNumber);
            System.out.println(ex.getClass().toString());
        }
    }
}
