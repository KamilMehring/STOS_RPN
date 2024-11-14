package zad;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RPNTest {

    @Test
    public void testSimpleAddition() {
        RPN calculator = new RPN(); //ONP
        int result = calculator.evaluate("3 4 +");
        assertEquals("3 + 4", 7, result);
    }

    @Test
    public void testSimpleSubtraction() {
        RPN calculator = new RPN(); 
        int result = calculator.evaluate("10 3 -");
        assertEquals("10 - 3", 7, result);
    }

    @Test
    public void testSimpleMultiplication() {
        RPN calculator = new RPN();
        int result = calculator.evaluate("2 3 *");
        assertEquals("2 * 3", 6, result);
    }

    @Test
    public void testComplexExpression() {
        RPN calculator = new RPN(); 
        int result = calculator.evaluate("5 1 2 + 4 * + 3 -");
        assertEquals("5 + ((1 + 2) * 4) - 3", 14, result);
    }
}
