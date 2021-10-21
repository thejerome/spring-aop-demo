package com.efimchick.springtutorial.aop.economics;

public interface Exchanger {
    default void pay(final Payment payment) {
        payment.getFrom().subtract(payment.getAmount());
        payment.getTo().add(payment.getAmount());
    }
}
