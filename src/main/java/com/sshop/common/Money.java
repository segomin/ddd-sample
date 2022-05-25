package com.sshop.common;

public record Money(int value) {

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }

    public static Money of(int value) {
        return new Money(value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
