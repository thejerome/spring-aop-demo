package com.efimchick.springtutorial.aop.students;

import java.util.ArrayList;
import java.util.List;

public class Student implements Studying {

    private final List<Lesson> attended = new ArrayList<>();
    private final String name;

    public Student(final String name) {
        this.name = name;
    }

    @Override
    public void attend(final Lesson lesson) {
        attended.add(lesson);
    }

    @Override
    public String toString() {
        return "Student " + name;
    }

    @Override
    public List<Lesson> attended() {
        return List.copyOf(attended);
    }
}
