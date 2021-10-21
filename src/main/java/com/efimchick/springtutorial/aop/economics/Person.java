package com.efimchick.springtutorial.aop.economics;

public class Person extends AbstractActor {

    private final String name;

    public Person(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + super.toString();
    }
}
