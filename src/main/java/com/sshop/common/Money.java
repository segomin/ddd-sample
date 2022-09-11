package com.sshop.common;

import lombok.Value;

import java.util.Objects;

@Value
public class Money {
    private final int value;

    public Money(int value) {this.value = value;}

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }

    public static Money of(int value) {
        return new Money(value);
    }

    public int value() {return value;}
}
