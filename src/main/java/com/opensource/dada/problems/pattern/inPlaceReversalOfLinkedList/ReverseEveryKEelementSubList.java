package com.opensource.dada.problems.pattern.inPlaceReversalOfLinkedList;

import com.opensource.dada.ds.list.LinkedListNode;

/**
 * Problem: https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseEveryKEelementSubList {
    public static void main(String[] args) {
        /**
         * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
         * Output:  3->2->1->6->5->4->8->7->NULL.
         */
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node7 = new LinkedListNode(7);
        LinkedListNode node8 = new LinkedListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        System.out.println("Before reverse:");
        LinkedListNode.print(node1);
        LinkedListNode reversedNode = reverseKElement(node1, 3);
        System.out.println("After reverse:");
        LinkedListNode.print(reversedNode);
        /**
         * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
         * Output:  5->4->3->2->1->8->7->6->NULL.
         */


    }

    static LinkedListNode reverseKElement(LinkedListNode head, int k) {
        LinkedListNode current = head;
        LinkedListNode next = null, previous = null;

        int count = 0;
        while (count<k && current!=null) {
            next = current.next;
            current.next=previous;
            previous = current;
            current = next;
            count++;
        }

        if (next!=null) {
            head.next = reverseKElement(next,k);
        }

        return previous;
    }
}
