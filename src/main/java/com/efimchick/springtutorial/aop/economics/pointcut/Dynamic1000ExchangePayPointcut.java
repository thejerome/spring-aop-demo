package com.efimchick.springtutorial.aop.economics.pointcut;

import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Payment;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Dynamic1000ExchangePayPointcut implements Pointcut {
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
                return true;
            }

            @Override
            public boolean matches(final Method method,
                                   final Class<?> targetClass,
                                   final Object... args) {
                if (!method.getName().equals("pay")) {
                    return false;
                }
                return ((Payment) args[0]).getAmount() > 1000;
            }
        };
    }
}
