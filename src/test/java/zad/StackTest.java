package zad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StackTest {

    @Test
    public void testPushAndPop() {
        Stack stack = new Stack();
        stack.push("napis");
        String result = stack.pop();
        assertEquals("pop after push", "napis", result);
    }

    @Test(expected = IllegalStateException.class)
    public void testPopOnEmptyStack() {
        Stack stack = new Stack();
        stack.pop();
    }

    @Test
    public void testPushAndPeek() {
        Stack stack = new Stack();
        stack.push("napis");
        String result = stack.peek();
        assertEquals("peek after push", "napis", result);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void testPeekOnEmptyStack() {
        Stack stack = new Stack();
        stack.peek();
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue("stos powinien być pusty", stack.isEmpty());
        stack.push("napis");
        assertFalse("stos nie powinien byc pusty", stack.isEmpty());
    }

    @Test
    public void testMultiplePushAndPop() {
        Stack stack = new Stack();
        stack.push("element1");
        stack.push("element2");
        stack.push("element3");
        assertEquals("element3", stack.pop());
        assertEquals("element2", stack.pop());
        assertEquals("element1", stack.pop());
        assertTrue("stos powinien być pusty after multiple pops", stack.isEmpty());
    }

    @Test
    public void testStackSizeAfterPush() {
        Stack stack = new Stack();
        for (int i = 0; i < 5; i++) {
            stack.push("element" + i);
        }
        assertFalse("stos nie powinien byc pusty after pushes", stack.isEmpty());
        assertEquals("element4", stack.pop());
    }

    @Test
    public void testStackResize() {
        Stack stack = new Stack();
        for (int i = 0; i < 15; i++) {
            stack.push("element" + i);
        }
        assertEquals("element14", stack.pop());
    }

    @Test
    public void testLifoOrder() {
        Stack stack = new Stack();
        stack.push("pierwszy");
        stack.push("drugi");
        stack.push("trzeci");
        assertEquals("trzeci", stack.pop());
        assertEquals("drugi", stack.pop());
        assertEquals("pierwszy", stack.pop());
    }

    @Test
    public void testMixedPushPop() {
        Stack stack = new Stack();
        stack.push("elementA");
        stack.push("elementB");
        assertEquals("elementB", stack.pop());
        stack.push("elementC");
        assertEquals("elementC", stack.pop());
        assertEquals("elementA", stack.pop());
        assertTrue("stos powinien być pusty after all pops", stack.isEmpty());
    }

    @Test
    public void testRepeatedPeek() {
        Stack stack = new Stack();
        stack.push("elementX");
        assertEquals("elementX", stack.peek());
        assertEquals("elementX", stack.peek());
        assertFalse("stos nie powinien byc pusty after peek", stack.isEmpty());
    }

    @Test
    public void testPushAfterClearingStack() {
        Stack stack = new Stack();
        stack.push("first");
        stack.pop();
        assertTrue("stos powinien być pusty after pop", stack.isEmpty());
        stack.push("second");
        assertEquals("second", stack.peek());
    }

    @Test
    public void testLargeNumberOfPushes() {
        Stack stack = new Stack();
        int elementsCount = 100;
        for (int i = 0; i < elementsCount; i++) {
            stack.push("element" + i);
        }
        assertEquals("element99", stack.pop());
        assertFalse("stos nie powinien byc pusty", stack.isEmpty());
    }

    @Test
    public void testPushNullElement() {
        Stack stack = new Stack();
        stack.push(null);
        assertEquals(null, stack.pop());
        assertTrue("stos powinien być pusty after popping null", stack.isEmpty());
    }
}
