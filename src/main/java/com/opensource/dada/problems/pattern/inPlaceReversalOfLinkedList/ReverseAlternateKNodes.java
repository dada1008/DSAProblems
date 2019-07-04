package com.opensource.dada.problems.pattern.inPlaceReversalOfLinkedList;

import com.opensource.dada.ds.list.LinkedListNode;

/**
 * https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 */
public class ReverseAlternateKNodes {
    public static void main(String[] args) {
        /**
         * Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
         * Output:   3->2->1->4->5->6->9->8->7->NULL.
         */
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node7 = new LinkedListNode(7);
        LinkedListNode node8 = new LinkedListNode(8);
        LinkedListNode node9 = new LinkedListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        System.out.println("Before reverse:");
        LinkedListNode.print(node1);
        LinkedListNode reversedNode = reverseAlternateKElement(node1, 3, true);
        System.out.println("After reverse:");
        LinkedListNode.print(reversedNode);
    }

    /**
     * _kAltReverse(LinkedListNode head, int k, bool b)
     * 1)  If b is true, then reverse first k nodes.
     * 2)  If b is false, then move the pointer k nodes ahead.
     * 3)  Call the kAltReverse() recursively for rest of the n - k nodes and link
     * rest of the modified list with end of first k nodes.
     * 4)  Return new head of the list.
     */
    public static LinkedListNode reverseAlternateKElement(LinkedListNode head, int k, boolean isReverse) {

        if (head==null) {
            return null;
        }
        LinkedListNode current = head;
        LinkedListNode next = null, previous = null, newHead = null;

        int count = 0;
        /* The loop serves two purposes
           1) If isReverse is true, then it reverses the k nodes
           2) If isReverse is false, then it moves the current pointer
        */
        while (count < k && current != null) {
            next = current.next;
            if (isReverse) {
                current.next = previous;
            }
            previous = current;
            current = next;
            count++;
        }
        /* 3) If isReverse is true, then node is the kth node.
             So attach rest of the list after node.
           4) After attaching, return the new head
        */
        if (isReverse) {
            head.next = reverseAlternateKElement(current, k, !isReverse);
            return previous;
        }/* If isReverse is false, then attach rest of the list after prev.
         So attach rest of the list after prev */ else {

            previous.next = reverseAlternateKElement(current, k, !isReverse);
            return head;
        }
    }
}
