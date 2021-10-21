package com.efimchick.springtutorial.aop.economics;

public class Payment {

    private final Actor from;
    private final Actor to;

    private final double amount;


    public Payment(Actor from, Actor to, double amount) {

        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public Actor getFrom() {
        return from;
    }

    public Actor getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }
}
