package com.efimchick.springtutorial.aop.economics.programs.five;

import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Government;
import com.efimchick.springtutorial.aop.economics.Payment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Economics5AspectJConfigVatSimpleAspect {

    private double rate;

    public Economics5AspectJConfigVatSimpleAspect(@Value("0.30") final double rate) {
        this.rate = rate;
    }

    @Pointcut("bean(bank) && execution(* pay(*)) && args(payment)")
    public void payPointcut(Payment payment){
    }

    @AfterReturning("payPointcut(payment)")
    public void execVat(JoinPoint joinPoint, Payment payment) {
        if (payment.getTo() instanceof Company) {
            Exchanger exchanger = (Exchanger) joinPoint.getThis();
            exchanger.pay(new Payment(payment.getTo(), Government.getGovernment(), payment.getAmount() * rate));
        }
    }

    @Around("payPointcut(payment)")
    public void cancelPayment(ProceedingJoinPoint proceedingJoinPoint, Payment payment) throws Throwable {
        if (payment.getFrom().balance() < payment.getAmount()){
            System.out.println("Vasya, kakoi coffee, zaplati za obshagy");
            return;
        }
        proceedingJoinPoint.proceed();
    }

    @Before("bean(bank)")
    public void some(){
        System.out.println("ItsaBank");
    }
}
