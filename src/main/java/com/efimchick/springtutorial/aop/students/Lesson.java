package com.efimchick.springtutorial.aop.students;

public class Lesson {

    private final String name;

    public Lesson(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
