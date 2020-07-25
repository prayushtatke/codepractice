package prg.linkedlist;

import prg.ds.Node;
import prg.ds.SinglyLinkedList;

public class FindMiddleElement {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = SinglyLinkedList.of(1, 2, 5, 4, 3, 7, 6, 8, 9);


        System.out.println("Input : " + sll);
        System.out.println("Output : " + findMiddle(sll));
    }

    private static int findMiddle(SinglyLinkedList<Integer> sll) {
        Node<Integer> slow, fast;
        slow = sll.head;
        fast = sll.head.next;
        while ( fast != null ) {
            fast = fast.next;
            slow = slow.next;

            if ( fast != null )
                fast = fast.next;
        }
        return slow.value;
    }
}
