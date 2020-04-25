package prg.ds;

public class Node2<T> {
    T value;
    public Node<T> next;
    public Node<T> prev;
    public Node2() {
    }

    public Node2(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value !=null? value.toString(): null;
    }
}
