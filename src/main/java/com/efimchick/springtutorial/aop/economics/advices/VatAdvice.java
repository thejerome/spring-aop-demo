package com.efimchick.springtutorial.aop.economics.advices;

import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Government;
import com.efimchick.springtutorial.aop.economics.Payment;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class VatAdvice implements MethodInterceptor {

    private final double rate;

    public VatAdvice(final double rate) {
        this.rate = rate;
    }

    @Override
    public Object invoke(final MethodInvocation invocation) throws Throwable {

        final Object retVal = invocation.proceed();

        final Payment payment = (Payment) invocation.getArguments()[0];
        if (payment.getTo() instanceof Company) {
            Exchanger exchanger = (Exchanger) invocation.getThis();
            exchanger.pay(new Payment(payment.getTo(), Government.getGovernment(), payment.getAmount() * rate));
        }

        return retVal;
    }
}
