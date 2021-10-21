package com.efimchick.springtutorial.aop.students;

import java.util.List;

public interface Studying {
    void attend(Lesson lesson);
    List<Lesson> attended();
}
