import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTest {
     Calculator calculator;

     @BeforeEach
     void setUp(){
         calculator = new Calculator();
     }

    @Test
    void testSubstract(){
        assertEquals(4.0, calculator.substract(7.0, 3.0));
        assertEquals(5, calculator.substract(7.5, 2.5));
        assertEquals(-6, calculator.substract(-3, 3));
        assertEquals(-12, calculator.substract(-5, 7));
        assertEquals(3, calculator.substract(3,0));
    }

    @Test
    void testMulitply(){
        assertEquals(21, calculator.multiply(7.0, 3.0));
        assertEquals(18.75, calculator.multiply(7.5, 2.5));
        assertEquals(-9, calculator.multiply(-3, 3));
        assertEquals(-35, calculator.multiply(-5, 7));
        assertEquals(0, calculator.multiply(3,0));
    }

    @Test
    void testDivide(){
        assertEquals(3, calculator.divide(9.0, 3.0));
        assertEquals(3, calculator.divide(7.5, 2.5));
        assertEquals(-1, calculator.divide(-3, 3));
        assertEquals(-10, calculator.divide(70, -7));
        assertThrowsExactly(ArithmeticException.class, () -> calculator.divide(3,0));
    }

    @Test
    void testAdd(){
        assertEquals(10.0, calculator.add(7.0, 3.0));
        assertEquals(10.0, calculator.add(7.5, 2.5));
        assertEquals(0, calculator.add(-3, 3));
        assertEquals(2.0, calculator.add(-5, 7));
        assertEquals(3, calculator.add(3,0));
    }

}
