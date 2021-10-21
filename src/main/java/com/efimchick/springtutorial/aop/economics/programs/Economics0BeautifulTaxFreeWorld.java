package com.efimchick.springtutorial.aop.economics.programs;

import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Government;
import com.efimchick.springtutorial.aop.economics.Payment;
import com.efimchick.springtutorial.aop.economics.Person;
import com.efimchick.springtutorial.aop.economics.RegularCashExchange;

public class Economics0BeautifulTaxFreeWorld {
    public static void main(String[] args) {

        final Person vasilii = new Person("Vasilii");
        final Company starbux = new Company("Starbux");
        final Company coffeeInc = new Company("Ethiopia Coffee Inc");
        final Government government = Government.getGovernment();

        vasilii.add(50);
        starbux.add(5000);
        coffeeInc.add(100);


        System.out.println("Initial State: ");
        System.out.println(government);
        System.out.println(vasilii);
        System.out.println(starbux);
        System.out.println(coffeeInc);
        System.out.println();

        new RegularCashExchange().pay(new Payment(vasilii, starbux, 5));

        System.out.println("After Transaction: ");
        System.out.println(government);
        System.out.println(vasilii);
        System.out.println(starbux);
        System.out.println(coffeeInc);


    }
}
