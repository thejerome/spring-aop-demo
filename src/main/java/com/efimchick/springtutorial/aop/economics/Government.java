package com.efimchick.springtutorial.aop.economics;

public class Government extends AbstractActor {

    private static Government government = new Government();

    public static Government getGovernment() {
        return government;
    }

    private Government() {
    }

    @Override
    public String toString() {
        return "Government: " + super.toString();
    }
}
