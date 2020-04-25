package prg.linkedlist;

import prg.ds.Node;
import prg.ds.SinglyLinkedList;

/**
 * 1:
 * Input : 2-->5-->4-->3-->7-->6-->8-->9
 * Output: 2-->4-->6-->8-->5-->3-->7-->9
 * 2:
 * Input : 1-->2-->5-->4-->3-->7-->6-->8-->9
 * Output: 2-->4-->6-->8-->1-->5-->3-->7-->9
 */
public class EvenPreceedOdd {


    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = SinglyLinkedList.of(1, 2, 5, 4, 3, 7, 6, 8, 9);

        System.out.println("Input : " + sll);
        evenPreceedOdds(sll);
        System.out.println("Output : " + sll);
    }


    /**
     * Create Odd and Even Subset.
     * take 4 pointers, Iterate over elements, if the current value is even, add it to even subset,
     * else add it to odd subet;
     *
     * in case of 'Even Precede Odd, the tail of the even set, will be pointing to OddHead,
     * Similarly 'Odds Precede even', the tail of the odd set, will be pointing to evenHead.
     */
    private static void evenPreceedOdds(SinglyLinkedList<Integer> sll) {
        Node<Integer> oddHead, oddTail, evenHead, evenTail;
        oddHead = oddTail = evenHead = evenTail = null;

        Node<Integer> curr = sll.head;
        while (curr != null) {
            if (curr.value % 2 == 0) {
                if (evenTail != null) {
                    evenTail.next = curr;
                    evenTail = curr;
                } else
                    evenHead = evenTail = curr;
            } else {
                if (oddHead != null) {
                    oddTail.next = curr;
                    oddTail = curr;
                } else
                    oddHead = oddTail = curr;
            }
            curr = curr.next;
        }
        oddTail.next = null;
        evenTail.next = null;

        // evens preceeds odds
        evenTail.next = oddHead;
        sll.head = evenHead;
        oddHead = null;

        // odds preceed evens
//        oddTail.next = evenHead;
//        sll.head = oddHead;
//        evenHead = null;

    }

}
