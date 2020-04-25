package prg.linkedlist;

import prg.ds.Node;
import prg.ds.SinglyLinkedList;

import java.util.IdentityHashMap;

public class FindCyclic {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> sll = SinglyLinkedList.of(1, 2, 5);
        Node<Integer> node = Node.get(4);
        sll.add(node);
        sll.addEnd(SinglyLinkedList.of(3, 7, 6, 8, 9));
        sll.tail.next = node;  // join tail to head
        System.out.println("Input : " + sll);
        System.out.println("Output : " + isCyclic2(sll));

     }

    private static boolean isCyclic(SinglyLinkedList<Integer> sll) {
        Node<Integer> slow, fast;
        slow = sll.head;
        fast = sll.head.next;
        while (fast != slow || fast != null ) {
            assert fast != null;
            fast = fast.next;
            slow = slow.next;

            if ( fast == slow)
                return true;

            if ( fast != null )
                fast = fast.next;

        }
        return false;
    }

    private static boolean isCyclic2(SinglyLinkedList<Integer> sll) {

        IdentityHashMap<Node,String> imap = new IdentityHashMap<>();
        Node<Integer> curr = sll.head;
        while (curr != null) {
            if ( imap.containsKey(curr) )
                return true;

            imap.put(curr, "");
            curr = curr.next;
        }
        return false;
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
