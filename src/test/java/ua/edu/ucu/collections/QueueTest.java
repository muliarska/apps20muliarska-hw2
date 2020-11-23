package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue testQueue;

    public QueueTest() {
        this.testQueue = new Queue();

        this.testQueue.enqueue(1);
        this.testQueue.enqueue(2);
        this.testQueue.enqueue(3);

        assertArrayEquals(testQueue.getData().toArray(), new Object[]{1, 2, 3});
        // Queue: 1, 2, 3
    }
    
    @Test
    public void testPeek() {
        assertEquals(testQueue.peek(), 1);
        assertArrayEquals(testQueue.getData().toArray(), new Object[]{1, 2, 3});
        // Queue: 1, 2, 3
    }

    @Test
    public void testDequeue() {
        assertEquals(testQueue.dequeue(), 1);
        assertArrayEquals(testQueue.getData().toArray(), new Object[]{2, 3});
        // Queue: 2, 3

        assertEquals(testQueue.dequeue(), 2);
        assertArrayEquals(testQueue.getData().toArray(), new Object[]{3});
        // Queue: 3

        assertEquals(testQueue.dequeue(), 3);
        assertArrayEquals(testQueue.getData().toArray(), new Object[]{});
        // Queue: null
    }

    @Test
    public void testEnqueue() {
        testQueue.enqueue(4);
        assertArrayEquals(testQueue.getData().toArray(), new Object[]{1, 2, 3, 4});
        // Queue: 1, 2, 3, 4

        testQueue.enqueue(5);
        assertArrayEquals(testQueue.getData().toArray(), new Object[]{1, 2, 3, 4, 5});
        // Queue: 1, 2, 3, 4, 5
    }
}
