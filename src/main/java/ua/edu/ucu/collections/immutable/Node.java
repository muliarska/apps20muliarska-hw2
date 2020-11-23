package ua.edu.ucu.collections.immutable;

public class Node {
    public Node next;
    public Object data;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}
