package com.opensource.dada.ds.list;

/**
 * Problem:
 * Write a method for reversing a linked list. ↴ Do it in place. ↴
 * <p>
 * Your method will have one input: the head of the list.
 * <p>
 * Your method should return the new head of the list.
 */
public class ReversingLinkedList {
    public static LinkedListNode reverse(LinkedListNode headOfList) {

        LinkedListNode previous = null;
        LinkedListNode next;
        LinkedListNode current = headOfList;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
