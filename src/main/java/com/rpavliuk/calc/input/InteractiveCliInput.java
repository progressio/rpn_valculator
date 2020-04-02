package com.rpavliuk.calc.input;

import com.rpavliuk.calc.engine.RpnEngine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InteractiveCliInput {

    private static final String HELP_MESSAGE = "This is RPN(reverse polish notation) calculator\n" +
            "which supports 4 basic arithmetic operations(+-*/). For example:\n" +
            "1 1 + == 2\n" +
            "2 3 * 5 - == 1";

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] elements = line.split(" ");

            // special commands
            if (elements.length > 0 && "-help".equals(elements[0])) {
                System.out.println(HELP_MESSAGE);
                continue;
            } else if (elements.length > 0 && "q".equals(elements[0])) {
                return;
            }

            // regular flow
            List<Object> parsed = new ArrayList<>();
            for (String el : elements) {
                try {
                    Double operand = Double.parseDouble(el);
                    parsed.add(operand);
                } catch (NumberFormatException ignored) {
                    if (el.length() == 1) {
                        parsed.add(el.charAt(0));
                    }
                }
            }

            System.out.println(RpnEngine.calculate(parsed.toArray()));
        }
    }
}
