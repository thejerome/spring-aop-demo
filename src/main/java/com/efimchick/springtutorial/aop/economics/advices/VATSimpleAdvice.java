package com.efimchick.springtutorial.aop.economics.advices;

import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Government;
import com.efimchick.springtutorial.aop.economics.Payment;
import org.aspectj.lang.JoinPoint;

public class VATSimpleAdvice {

    private final double rate;

    public VATSimpleAdvice(final double rate) {
        this.rate = rate;
    }

    public void execVat(JoinPoint joinPoint, Payment payment) {
        
        if (payment.getTo() instanceof Company) {
            Exchanger exchanger = (Exchanger) joinPoint.getThis();
            exchanger.pay(new Payment(payment.getTo(), Government.getGovernment(), payment.getAmount() * rate));
        }

    }
}
