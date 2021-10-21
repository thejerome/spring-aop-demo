package com.efimchick.springtutorial.aop.economics.pointcut;

import com.efimchick.springtutorial.aop.economics.Exchanger;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.Arrays;

public class SimpleExchangePayPointcut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
        return clazz -> Arrays.asList(clazz.getInterfaces()).contains(Exchanger.class);
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return new MethodMatcher() {
            @Override
            public boolean matches(final Method method, final Class<?> targetClass) {
                return method.getName().equals("pay");
            }

            @Override
            public boolean isRuntime() {
                return false;
            }

            @Override
            public boolean matches(final Method method, final Class<?> targetClass, final Object... args) {
                throw new UnsupportedOperationException();
            }
        };
    }
}
