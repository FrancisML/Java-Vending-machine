package com.techelevator;

public class Money {

    private double balance = 0.0;

    public double getBalance() {
        return this.balance;
    }

    public double feedMoney(int dollars) {
        this.balance += dollars;
        return this.balance;
    }

    public double reduceMoney(double purchaseAmount) {
        this.balance -= purchaseAmount;
        return this.balance;
    }
}
