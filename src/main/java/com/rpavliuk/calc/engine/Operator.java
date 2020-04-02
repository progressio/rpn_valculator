package com.rpavliuk.calc.engine;

public enum Operator {
    Add('+'),
    Subtract('-'),
    Multiply('*'),
    Divide('/');

    private char symbol;

    Operator(char symbol) {
        this.symbol = symbol;
    }

    static Operator valueOf(char symbol) {
        for (Operator o : values()) {
            if (o.symbol == symbol) {
                return o;
            }
        }

        return null;
    }
}
