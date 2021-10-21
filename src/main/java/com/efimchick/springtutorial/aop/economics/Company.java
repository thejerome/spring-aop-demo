package com.efimchick.springtutorial.aop.economics;

public class Company extends AbstractActor {
    private final String name;

    public Company(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company \"" + name + "\": " + super.toString();
    }
}
