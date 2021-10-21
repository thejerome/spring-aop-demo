package com.efimchick.springtutorial.aop.economics.programs;

import com.efimchick.springtutorial.aop.economics.advices.VatAdvice;
import com.efimchick.springtutorial.aop.economics.Bank;
import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Government;
import com.efimchick.springtutorial.aop.economics.Payment;
import com.efimchick.springtutorial.aop.economics.Person;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class Economics1Pointcuts {
    public static void main(String[] args) {

        final VatAdvice vat = new VatAdvice(0.20);

        final Person vasilii = new Person("Vasilii");
        final Company starbux = new Company("Starbux");
        final Company coffeeInc = new Company("Ethiopia Coffee Inc");
        final Government government = Government.getGovernment();

        vasilii.add(50);
        starbux.add(5000);
        coffeeInc.add(100);

        ProxyFactory bankTaxingPf = new ProxyFactory(new Bank());

        final AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

        pointcut.setExpression("execution(* pay(*))");

        bankTaxingPf.addAdvisor(new DefaultPointcutAdvisor(pointcut, vat));

        Exchanger bank = (Exchanger) bankTaxingPf.getProxy();

        System.out.println("Initial State: ");
        System.out.println(government);
        System.out.println(vasilii);
        System.out.println(starbux);
        System.out.println(coffeeInc);
        System.out.println();

        bank.pay(new Payment(vasilii, starbux, 5));
        bank.pay(new Payment(starbux, coffeeInc, 3000));

        System.out.println("After Transaction: ");
        System.out.println(government);
        System.out.println(vasilii);
        System.out.println(starbux);
        System.out.println(coffeeInc);


    }
}
