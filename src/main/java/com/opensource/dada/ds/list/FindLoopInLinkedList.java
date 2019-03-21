package com.opensource.dada.ds.list;

/**
 * Problem:
 * Write a method to find a linked list has loop or not. Do it in place.
 * <p>
 * Your method will have one input: the head of the list.
 * <p>
 * Your method should return true or false.
 */
public class FindLoopInLinkedList {

    public static boolean detectLoop(LinkedListNode headOfList)
    {
        LinkedListNode slow_p = headOfList, fast_p = headOfList;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                System.out.println("Found loop");
                return true;
            }
        }
        return false;
    }
}
