package prg.linkedlist;


import prg.ds.Node;
import prg.ds.SinglyLinkedList;

/**
 * 1:
 * Input : 2-->5-->4-->3-->7-->6-->8-->9
 * Output: 2-->4-->6-->8-->5-->3-->7-->9
 */
public class FindNthElementFromLast {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = SinglyLinkedList.of(1, 2, 5, 4, 3, 7, 6, 8, 9);

        System.out.println("Input : " + sll);
        System.out.println("Output : " + findNthFromLast2(4,sll));

    }

    private static int findNthFromLast(int n, SinglyLinkedList<Integer> sll) {
        Node<Integer> slow,fast;
        slow = null;
        fast = sll.head;
        int counter = 0;
        while(fast != null) {
            fast = fast.next;
            if ( counter  == n )
                slow = sll.head;

            if( slow != null )
                slow = slow.next;

            counter++;
        }
        return slow.value;
    }

    private static int findNthFromLast2(int n, SinglyLinkedList<Integer> sll) {
        Node<Integer> slow,fast;
        slow = null;
        fast = sll.head;
        int counter = 0;
        while(fast != null) {
            fast = fast.next;
            if ( counter < n )
                counter++;
            else
                slow = slow != null ? slow.next : sll.head.next;
        }
        return slow.value;
    }
}
