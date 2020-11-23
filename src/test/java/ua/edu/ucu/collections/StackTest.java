package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    Stack testStack;

    public StackTest() {
        this.testStack = new Stack();

        this.testStack.push(1);
        this.testStack.push(2);
        this.testStack.push(3);

        assertArrayEquals(testStack.data.toArray(), new Object[]{1, 2, 3});
        // Stack: 1, 2, 3
    }

    @Test
    public void testPeek() {
        assertEquals(testStack.peek(), 3);
        assertArrayEquals(testStack.data.toArray(), new Object[]{1, 2, 3});
        // Stack: 1, 2, 3
    }

    @Test
    public void testPop() {
        assertEquals(testStack.pop(), 3);
        assertArrayEquals(testStack.data.toArray(), new Object[]{1, 2});
        // Stack: 1, 2

        assertEquals(testStack.pop(), 2);
        assertArrayEquals(testStack.data.toArray(), new Object[]{1});
        // Stack: 1

        assertEquals(testStack.pop(), 1);
        assertArrayEquals(testStack.data.toArray(), new Object[]{});
        // Stack: null
    }

    @Test
    public void testPush() {
        testStack.push(4);
        assertArrayEquals(testStack.data.toArray(), new Object[]{1, 2, 3, 4});
        // Stack: 1, 2, 3, 4

        testStack.push(5);
        assertArrayEquals(testStack.data.toArray(), new Object[]{1, 2, 3, 4, 5});
        // Stack: 1, 2, 3, 4, 5
    }
    
}
