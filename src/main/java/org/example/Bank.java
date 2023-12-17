package org.example;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Integer> accounts = new HashMap<>();

    private Map<Integer, Object> locks = new HashMap<>();

    public void deposit(int accountNumber, int amount) {
        synchronized (getLock(accountNumber)) {
            int balance = accounts.getOrDefault(accountNumber, 0);
            accounts.put(accountNumber, balance + amount);
            System.out.println("Deposited $" + amount + " into account " + accountNumber);
        }
    }

    public void withdraw(int accountNumber, int amount) {
        synchronized (getLock(accountNumber)) {
            int balance = accounts.getOrDefault(accountNumber, 0);
            if (balance >= amount) {
                accounts.put(accountNumber, balance - amount);
                System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds for withdrawal from account " + accountNumber);
            }
        }
    }

    public int getBalance(int accountNumber) {
        synchronized (getLock(accountNumber)) {
            return accounts.getOrDefault(accountNumber, 0);
        }
    }

    private Object getLock(int accountNumber) {
        locks.putIfAbsent(accountNumber, new Object());
        return locks.get(accountNumber);
    }
}
