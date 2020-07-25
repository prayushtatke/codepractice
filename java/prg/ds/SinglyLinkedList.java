package prg.ds;

import java.util.List;

public class SinglyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;


    public SinglyLinkedList() {
    }

    public static <T> SinglyLinkedList<T> of(T val1, T... vars) {
        SinglyLinkedList<T> sll = new SinglyLinkedList<>();
        sll.add(val1);
        List.of(vars).forEach(sll::add);
        return sll;
    }


    public void add(T t) {
        add(Node.get(t));
    }

    public void add(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        // adding the new Node to current tail.
        tail.next = node;
        // progressing tail so that the newly added becomes tail.
        tail = tail.next;
    }

    public void addEnd(T val1, T... vars) {
        addEnd(SinglyLinkedList.of(val1, vars));
    }

    public void addEnd(SinglyLinkedList<T> other) {
        if (head == null) {
            head = other.head;
            tail = other.tail;
            return;
        }

        tail.next = other.head;
        tail = other.tail;

    }

    public void addBefore(SinglyLinkedList<T> other) {
        if (head == null) {
            head = other.head;
            tail = other.tail;
            return;
        }

        other.tail.next = head;
        head = other.head;

    }

    @Override
    public String toString() {
        if (head == null)
            return "null";

        StringBuilder str = new StringBuilder();
        Node<T> curr = head;
//        while (curr != null) {
//            str.append(curr.value);
//
//            if (curr.next != null)
//                str.append("-->");
//
//            curr = curr.next;
//        }

//        Node<T> currSlow, fast;
//        currSlow = head;
//        fast = head.next;
//        while (currSlow != null ) {
//            str.append(currSlow.value);
//            if (currSlow.next != null)
//                str.append("-->");
//
//            progressPointer(fast);
//            progressPointer(currSlow);
//
//            if (fast == currSlow)
//                 break;
//
//            progressPointer(fast);
//        }
        return str.toString();
    }

    private void progressPointer(Node<T> node) {
        if (node == null)
            return;

        node = node.next;
    }
}
