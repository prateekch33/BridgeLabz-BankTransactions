package org.example;

public class Customer extends Thread{
    private static int nextCustomerId = 1;
    private int customerId;
    private Bank bank;

    public Customer(Bank bank) {
        this.customerId = nextCustomerId++;
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            int amount = (int) (Math.random() * 100) + 1;
            bank.deposit(customerId, amount);
            amount = (int) (Math.random() * 50) + 1;
            bank.withdraw(customerId, amount);
            System.out.println("Account " + customerId + " Balance: Rs." + bank.getBalance(customerId));
        }
    }
}
