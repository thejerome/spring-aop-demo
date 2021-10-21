package com.efimchick.springtutorial.aop.students;

import com.efimchick.springtutorial.aop.students.advices.AttendedAfterAdvice;
import com.efimchick.springtutorial.aop.students.advices.CoinProbabilityMethodInterceptor;
import com.efimchick.springtutorial.aop.students.advices.OnlySpringAllowedBeforeAdvice;
import com.efimchick.springtutorial.aop.students.pointcut.StudyingPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainAOP {

    public static void main(String[] args) {

        final Student bob = new Student("Bob");
        final Student alice = new Student("Alice");

        final List<Studying> proxyStudents = Stream.of(alice, bob)
                .map(student -> {
                    ProxyFactory proxyFactory = buildProxyFactory();
                    proxyFactory.setTarget(student);
                    return (Studying) proxyFactory.getProxy();
                })
                .collect(Collectors.toList());


        proxyStudents.forEach(System.out::println);

        Lesson lessonDi = new Lesson("Spring DI");
        Lesson lessonAop = new Lesson("Spring AOP");

        proxyStudents.forEach(student -> student.attend(lessonAop));
        proxyStudents.forEach(student -> student.attend(lessonDi));
        proxyStudents.forEach(student -> student.attend(new Lesson("Scala Basics")));


        proxyStudents.forEach(s -> System.out.println(s.attended()));

    }

    private static ProxyFactory buildProxyFactory() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(
                new StudyingPointcut(),
                new CoinProbabilityMethodInterceptor()
        ));
        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(
                new StudyingPointcut(),
                new OnlySpringAllowedBeforeAdvice()
        ));
        proxyFactory.addAdvice(new AttendedAfterAdvice());
        return proxyFactory;
    }


}
