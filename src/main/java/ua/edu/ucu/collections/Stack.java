package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import ua.edu.ucu.collections.immutable.Node;

public class Stack {
    ImmutableLinkedList data;

    public Stack() {
        this.data = new ImmutableLinkedList(null);
    }

    Object peek() {
        return this.data.getLast();
    }

    Object pop() {
        Node temp = this.data.head;
        this.data = this.data.removeLast();
        return temp.data;
    }

    void push(Object e) {
        this.data = this.data.addLast(e);
    }

}
