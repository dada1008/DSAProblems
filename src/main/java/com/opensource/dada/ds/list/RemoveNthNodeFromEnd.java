package com.opensource.dada.ds.list;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example, given linked list 1->2->3->4->5 and n = 2, the result is 1->2->3->5.
 */
public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {

    }

    public LinkedListNode removeNthFromEnd(LinkedListNode head, int n) {
        if(head == null)
            return null;

        LinkedListNode fast = head;
        LinkedListNode slow = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        //if remove the first node
        if(fast == null){
            head = head.next;
            return head;
        }

        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
