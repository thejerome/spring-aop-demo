package com.efimchick.springtutorial.aop.students.advices;

import com.efimchick.springtutorial.aop.students.Studying;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AttendedAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(final Object returnValue,
                               final Method method,
                               final Object[] args,
                               final Object target) throws Throwable {

        if (target instanceof Studying
                && method.getName().equals("attend")) {
            System.out.println(target + " attended " + args[0].toString());
        }
    }
}
