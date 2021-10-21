package com.efimchick.springtutorial.aop.students.advices;

import com.efimchick.springtutorial.aop.students.Studying;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class AttendanceRefusedAfterAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method,
                              Object[] args,
                              Object target,
                              IllegalStateException exception) {
        if (target instanceof Studying
                && method.getName().equals("attend")) {
            System.out.println(target + " has been refused from " + args[0].toString());
        }
    }

}
