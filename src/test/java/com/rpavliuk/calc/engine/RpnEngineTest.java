package com.rpavliuk.calc.engine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RpnEngineTest {

    @Test
    public void testInvalidInput() {
        try {
            RpnEngine.calculate(1, 2);
            fail("it's not valid without operators");
        } catch (Exception ignored) {
        }

        try {
            RpnEngine.calculate('^');
            fail("engine supports 4 basic operators only");
        } catch (Exception ignored) {
        }

        try {
            RpnEngine.calculate(1, '+');
            fail("should fail with 1 operand");
        } catch (Exception ignored) {
        }

        try {
            RpnEngine.calculate(1, 2, 3, '+');
            fail("should fail because more than 1 operand left in the end");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testValidInput() {
        assertEquals(1, RpnEngine.calculate(1.0), 0.0);
        assertEquals(2.0, RpnEngine.calculate(1.0, 1.0, '+'), 0.0);
        assertEquals(1.0, RpnEngine.calculate(2.0, 1.0, '-'), 0.0);
        assertEquals(6.0, RpnEngine.calculate(2.0, 3.0, '*'), 0.0);
        assertEquals(2.0, RpnEngine.calculate(4.0, 2.0, '/'), 0.0);

        assertEquals(-4.0, RpnEngine.calculate(1.0, 2.0, 3.0, '+', '-'), 0.0);
        assertEquals(0.0, RpnEngine.calculate(1.0, 1.0, '-', 3.0, '*'), 0.0);
        assertEquals(1.0, RpnEngine.calculate(7.0, 2.0, 3.0, '*', '-'), 0.0);
        assertEquals(-15.0, RpnEngine.calculate(10.0, 15.0, '-', 3.0, '*'), 0.0);
        assertEquals(-15.0, RpnEngine.calculate(3.0, 10.0, 15.0, '-', '*'), 0.0);
        assertEquals(15.0, RpnEngine.calculate(1.0, 2.0, '+', 4.0, '*', 3.0, '+'), 0.0);
        assertEquals(0.0, RpnEngine.calculate(5.0, 8.0, '+', 13.0, '-'), 0.0);
        assertEquals(11.0, RpnEngine.calculate(-3.0, -2.0, '*', 5.0, '+'), 0.0);
        assertEquals(0.625, RpnEngine.calculate(5.0, 9.0, 1.0, '-', '/'), 0.0);
    }
}
