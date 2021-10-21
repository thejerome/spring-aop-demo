package com.efimchick.springtutorial.aop.economics.programs;

import com.efimchick.springtutorial.aop.economics.advices.VatAdvice;
import com.efimchick.springtutorial.aop.economics.Bank;
import com.efimchick.springtutorial.aop.economics.Company;
import com.efimchick.springtutorial.aop.economics.Person;
import com.efimchick.springtutorial.aop.economics.pointcut.SimpleExchangePayPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Economics3PFBConfig {

    @Bean
    public VatAdvice vatAdvice() {
        return new VatAdvice(0.20);
    }

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
    public ProxyFactoryBean bankProxyFactoryBean() {
        ProxyFactoryBean bankTaxingPfb = new ProxyFactoryBean();
        bankTaxingPfb.setTarget(new Bank());
        bankTaxingPfb.addAdvisor(new DefaultPointcutAdvisor(new SimpleExchangePayPointcut(), vatAdvice()));
        return bankTaxingPfb;
    }
}
