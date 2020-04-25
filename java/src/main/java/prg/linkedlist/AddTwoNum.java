package prg.linkedlist;

import prg.ds.Node;
import prg.ds.SinglyLinkedList;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list. You may assume the two numbers do not contain any leading zero,
except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class AddTwoNum {

    public static void main(String[] args) {

        SinglyLinkedList<Integer> l1 = SinglyLinkedList.of(2, 4, 3);
        System.out.println(l1);

        SinglyLinkedList<Integer> l2 = SinglyLinkedList.of(5, 6, 4, 3);
        System.out.println(l2);

        System.out.println(addTwoNum(l1, l2));

    }

    private static SinglyLinkedList<Integer> addTwoNum(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
        SinglyLinkedList<Integer> result = new SinglyLinkedList<>();
        Node<Integer> l1Curr = l1.head;
        Node<Integer> l2Curr = l2.head;

        int i = 0;
        while (l1Curr != null || l2Curr != null ) {
            int sum = i;

            if ( l1Curr != null )
                sum += l1Curr.value ;

            if ( l2Curr  != null )
                sum += l2Curr.value ;

            if ( sum > 10 )
                i = sum - 10;
            else if ( 10 == sum ) {
                i = 1;
                sum = 0;
            }
            else
                i = 0;

            result.add(sum);
            l1Curr = l1Curr != null ? l1Curr.next : null;
            l2Curr = l2Curr != null ? l2Curr.next : null;

        }

        return result;
    }
}
