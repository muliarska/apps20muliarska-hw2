package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.Node;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList data;

    public Queue() {
        this.data = new ImmutableLinkedList(null);
    }

    public Object peek() {
        return this.data.getFirst();
    }

    public Object dequeue() {
        Node temp = this.data.head;
        this.data = this.data.removeFirst();
        return temp.data;
    }

    public void enqueue(Object e) {
        this.data = this.data.addLast(e);
    }

}
