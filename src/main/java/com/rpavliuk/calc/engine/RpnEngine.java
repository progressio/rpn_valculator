package com.rpavliuk.calc.engine;

import java.util.Stack;

public class RpnEngine {
    public static double calculate(Object... elements) {
        if (elements.length == 0) {
            return 0;
        }

        Stack<Double> stack = new Stack<>();
        for (Object el : elements) {
            // add operands to stack
            if (el.getClass().isAssignableFrom(Double.class)) {
                stack.push((Double) el);
            }
            // perform operation on last 2 operands in stack
            else {
                Operator op = Operator.valueOf((char) el);
                if (op == null) {
                    throw new InvalidInputException("unknown operator " + el);
                }

                if (stack.empty()) {
                    throw new InvalidInputException("no operands before " + el);
                }
                Double operand2 = stack.pop();

                if (stack.empty()) {
                    throw new InvalidInputException("only one operand left for " + el);
                }
                Double operand1 = stack.pop();

                switch (op) {
                    case Add: {
                        stack.push(operand1 + operand2);
                        break;
                    }
                    case Subtract: {
                        stack.push(operand1 - operand2);
                        break;
                    }
                    case Multiply: {
                        stack.push(operand1 * operand2);
                        break;
                    }
                    case Divide: {
                        stack.push(operand1 / operand2);
                        break;
                    }
                }
            }
        }

        if (stack.empty()) {
            throw new InvalidInputException("can not calculate any result");
        } else if (stack.size() > 1) {
            throw new InvalidInputException("calculation stuck on last " + stack.size() + " elements");
        }

        return stack.pop();
    }
}

