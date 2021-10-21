package com.efimchick.springtutorial.aop.economics;

public abstract class AbstractActor implements Actor {
    private double balance = 0;

    @Override
    public double balance() {
        return balance;
    }

    @Override
    public void add(double amount) {
        balance = balance + amount;
    }

    @Override
    public void subtract(double amount) {
        balance = balance - amount;
    }

    @Override
    public String toString() {
        return String.format("%.2f", balance);
    }
}
