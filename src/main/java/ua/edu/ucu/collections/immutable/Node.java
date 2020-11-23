package ua.edu.ucu.collections.immutable;

public class Node {
    public Node next = null;
    public Object data;

    public Node(Object data) {
        this.data = data;
    }
}
