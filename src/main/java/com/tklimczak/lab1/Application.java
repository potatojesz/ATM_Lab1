package com.tklimczak.lab1;

import com.tklimczak.lab1.executors.ATMServiceExecutor;

public class Application {
    public static void main(String [ ] args) throws InterruptedException {
        ATMServiceExecutor thread1 = new ATMServiceExecutor("1");
        thread1.start();
        Thread.sleep(100);
        ATMServiceExecutor thread2 = new ATMServiceExecutor("2");
        thread2.start();
    }
}
