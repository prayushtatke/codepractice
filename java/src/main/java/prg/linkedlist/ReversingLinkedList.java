package prg.linkedlist;

import prg.ds.Node;
import prg.ds.SinglyLinkedList;

/**
 * 1:
 * Input : 1-->2-->5-->4-->3-->7-->6-->8-->9
 * Output: 9-->8-->6-->7-->3-->4-->5-->2-->1
 */

public class ReversingLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = SinglyLinkedList.of(1, 2, 5, 4, 3, 7, 6, 8, 9);

        System.out.println("Input : " + sll);
//        reverseIterative(sll);
        reverseRecursive(sll);
        System.out.println("Output : " + sll);
    }


    private static void reverseIterative(SinglyLinkedList<Integer> sll) {
        Node<Integer> prev,next;
        prev = next = null;

        Node<Integer> curr = sll.head;
        while ( curr != null ) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        sll.head = prev;
    }


    private static void reverseRecursive(SinglyLinkedList<Integer> sll) {
        reverseRecursive(sll,sll.head,null);
    }


    private static void reverseRecursive(SinglyLinkedList<Integer> sll, Node<Integer> curr, Node<Integer> prev) {
        if ( curr == null ) {
            sll.head = prev;
            return;
        }
        Node<Integer> next = curr.next;
        curr.next = prev;
        prev = curr;
        reverseRecursive(sll, next, prev);

    }

}
