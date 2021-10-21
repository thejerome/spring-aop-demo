package com.efimchick.springtutorial.aop.students.advices;

import com.efimchick.springtutorial.aop.students.Lesson;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class OnlySpringAllowedBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(final Method method,
                       final Object[] args,
                       final Object target) throws Throwable {

        if (args[0] != null
                && !args[0].toString().contains("Spring")) {

            args[0] = new Lesson("Spring " + args[0].toString());
        }
    }
}
