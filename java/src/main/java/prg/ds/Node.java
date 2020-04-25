package prg.ds;

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public static <T> Node<T> get(T value) {
        return new Node<T>(value);
    }

    @Override
    public String toString() {
        return value != null ? value.toString() : null;
    }
}