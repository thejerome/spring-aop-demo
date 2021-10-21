package com.efimchick.springtutorial.aop;

import com.efimchick.springtutorial.aop.students.Lesson;
import com.efimchick.springtutorial.aop.students.Student;
import com.efimchick.springtutorial.aop.students.Studying;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Lesson lessonDi = new Lesson("Spring DI");
        Lesson lessonAop = new Lesson("Spring AOP");

        final Student bob = new Student("Bob");
        final Student alice = new Student("Alice");

        final List<Studying> surveyedStudents = Stream.of(alice, bob)
                .map(student -> Proxy.newProxyInstance(
                        Main.class.getClassLoader(),
                        new Class[]{Studying.class},
                        new SurveyedStudyingInvocationHandler(student)
                ))
                .filter(Studying.class::isInstance)
                .map(Studying.class::cast)
                .collect(Collectors.toList());

        surveyedStudents.forEach(System.out::println);


        surveyedStudents.forEach(student -> student.attend(lessonAop));
        surveyedStudents.forEach(student -> student.attend(lessonDi));
        surveyedStudents.forEach(student -> student.attend(new Lesson("Scala for begginers")));

    }

    private static class SurveyedStudyingInvocationHandler implements InvocationHandler {

        private final Student surveyed;

        private SurveyedStudyingInvocationHandler(final Student surveyed) {
            this.surveyed = surveyed;
        }

        @Override
        public Object invoke(final Object proxy,
                             final Method method,
                             final Object[] args) throws Throwable {

            if (method.getName().equals("attend")) {
                final Lesson lesson = (Lesson) args[0];
                System.out.println(surveyed + " tries to attend " + lesson.toString());
                if (!lesson.toString().contains("Spring")) {
                    System.out.println(surveyed + " has been rejected from " + lesson.toString());
                    return null;
                }
                System.out.println(surveyed + " attended " + lesson.toString());

            }

            return method.invoke(surveyed, args);
        }
    }
}
