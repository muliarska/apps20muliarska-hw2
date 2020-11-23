package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList data;

    public Queue() {
        this.data = new ImmutableLinkedList(null);
    }

    public ImmutableLinkedList getData() {
        return data;
    }

    public Object peek() {
        return this.data.getFirst();
    }

    public Object dequeue() {
        Object temp = this.peek();
        this.data = this.data.removeFirst();
        return temp;
    }

    public void enqueue(Object e) {
        this.data = this.data.addLast(e);
    }

}
