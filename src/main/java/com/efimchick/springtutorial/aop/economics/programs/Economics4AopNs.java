package com.efimchick.springtutorial.aop.economics.programs;

import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Government;
import com.efimchick.springtutorial.aop.economics.Payment;
import com.efimchick.springtutorial.aop.economics.Person;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Economics4AopNs {
    public static void main(String[] args) {


        GenericXmlApplicationContext context =
                new GenericXmlApplicationContext("economics/economics-aop.xml");

        final Person vasilii = context.getBean("vasya", Person.class);
        final Company starbux = context.getBean("starbux", Company.class);
        final Company coffeeInc = context.getBean("eci", Company.class);
        final Government government = Government.getGovernment();

        vasilii.add(50);
        starbux.add(5000);
        coffeeInc.add(100);

        Exchanger bank = context.getBean(Exchanger.class);

        System.out.println("Initial State: ");
        System.out.println(government);
        System.out.println(vasilii);
        System.out.println(starbux);
        System.out.println(coffeeInc);
        System.out.println();

        bank.pay(new Payment(vasilii, starbux, 5));

        System.out.println("After Transaction: ");
        System.out.println(government);
        System.out.println(vasilii);
        System.out.println(starbux);
        System.out.println(coffeeInc);

    }
}
