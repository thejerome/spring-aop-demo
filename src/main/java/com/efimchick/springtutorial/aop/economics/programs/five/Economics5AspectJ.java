package com.efimchick.springtutorial.aop.economics.programs.five;

import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Government;
import com.efimchick.springtutorial.aop.economics.Payment;
import com.efimchick.springtutorial.aop.economics.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Economics5AspectJ {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Economics5AspectJConfig.class);

        final Person vasilii = context.getBean("vasilii", Person.class);
        final Company starbux = context.getBean("starbux", Company.class);
        final Company coffeeInc = context.getBean("coffeeInc", Company.class);
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

        for (int i = 0; i < 100; i++) {
            bank.pay(new Payment(vasilii, starbux, 5));
        }

        System.out.println("After Transaction: ");
        System.out.println(government);
        System.out.println(vasilii);
        System.out.println(starbux);
        System.out.println(coffeeInc);

//        System.out.println(context.getBean(Economics5AspectJConfigVatSimpleAspect.class));

    }
}
