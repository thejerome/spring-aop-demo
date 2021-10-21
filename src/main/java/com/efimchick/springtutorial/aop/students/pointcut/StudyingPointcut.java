package com.efimchick.springtutorial.aop.students.pointcut;

import com.efimchick.springtutorial.aop.students.Studying;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.Arrays;

public class StudyingPointcut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
        return clazz -> Arrays.asList(clazz.getInterfaces()).contains(Studying.class);
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(final Method method,
                                   final Class<?> targetClass) {
                return method.getName().equals("attend");
            }

            @Override
            public boolean isRuntime() {
                return false;
            }

            @Override
            public boolean matches(final Method method,
                                   final Class<?> targetClass,
                                   final Object... args) {
                throw new UnsupportedOperationException();
            }
        };
    }


}
