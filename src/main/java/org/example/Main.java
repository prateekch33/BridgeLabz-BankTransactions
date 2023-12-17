package org.example;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Customer customer1 = new Customer(bank);
        Customer customer2 = new Customer(bank);
        Customer customer3 = new Customer(bank);

        customer1.start();
        customer2.start();
        customer3.start();

        try {
            customer1.join();
            customer2.join();
            customer3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Account Balances:");
        for (int customerId = 1; customerId <= 3; customerId++) {
            System.out.println("Account " + customerId + ": Rs." + bank.getBalance(customerId));
        }
    }
}