package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList data;

    public Stack() {
        this.data = new ImmutableLinkedList(null);
    }

    public ImmutableLinkedList getData() {
        return data;
    }

    Object peek() {
        return this.data.getLast();
    }

    Object pop() {
        Object temp = this.peek();
        this.data = this.data.removeLast();
        return temp;
    }

    void push(Object e) {
        this.data = this.data.addLast(e);
    }

}
