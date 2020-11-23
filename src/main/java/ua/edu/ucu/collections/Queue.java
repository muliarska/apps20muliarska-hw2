package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.Node;
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
        Node temp = this.data.getHead();
        this.data = this.data.removeFirst();
        return temp.data;
    }

    public void enqueue(Object e) {
        this.data = this.data.addLast(e);
    }

}
