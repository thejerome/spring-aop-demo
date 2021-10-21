package com.efimchick.springtutorial.aop.students.advices;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Random;

public class CoinProbabilityMethodInterceptor implements MethodInterceptor {
    private final Random random = new Random();

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {

        if (random.nextBoolean()){
            return invocation.proceed();
        }
        System.out.println("Not gonna go");
        return null;
    }
}
