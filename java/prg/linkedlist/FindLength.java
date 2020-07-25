package prg.linkedlist;

import prg.ds.Node;
import prg.ds.SinglyLinkedList;

public class FindLength {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = SinglyLinkedList.of(1, 2, 5, 4, 3, 7, 6, 8, 9);

        System.out.println("Input : " + sll);
        System.out.println("Output Iterative: " +findLengthIterative(sll));
        System.out.println("Output Recursive: " +findLengthRecursive(sll));
    }

    private static int findLengthIterative(SinglyLinkedList<Integer> sll) {
        int length = 0;
        Node<Integer> curr = sll.head;
        while ( curr != null ) {
            curr = curr.next;
            length++;
        }
        return length;
    }

    private static int findLengthRecursive(SinglyLinkedList<Integer> sll) {
        return length(sll.head,0);
    }

    private static int length(Node<Integer> curr, int length) {
        if (curr == null )
            return length;

        return length(curr.next,length +1 );
    }
}
