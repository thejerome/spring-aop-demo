package com.efimchick.springtutorial.aop.economics.programs.five;

import com.efimchick.springtutorial.aop.economics.Bank;
import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Exchanger;
import com.efimchick.springtutorial.aop.economics.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = Economics5AspectJConfigVatSimpleAspect.class)
@EnableAspectJAutoProxy
public class Economics5AspectJConfig {

    @Bean
    public Person vasilii() {
        return new Person("Vasilii");
    }

    @Bean
    public Company starbux() {
        return new Company("Starbux");
    }

    @Bean
    public Company coffeeInc() {
        return new Company("Ethiopia Coffee Inc");
    }

    @Bean
    public Exchanger bank() {
        return new Bank();
    }

}
