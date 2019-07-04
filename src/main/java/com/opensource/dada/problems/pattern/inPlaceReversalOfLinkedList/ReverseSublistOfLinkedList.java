package com.opensource.dada.problems.pattern.inPlaceReversalOfLinkedList;

import com.opensource.dada.ds.list.LinkedListNode;

/**
 * Problem: https://leetcode.com/problems/reverse-linked-list-ii
 *          https://www.geeksforgeeks.org/reverse-sublist-linked-list/
 */
public class ReverseSublistOfLinkedList {
    public static void main(String[] args) {

    }

    public LinkedListNode reverseBetween(LinkedListNode head, int m, int n) {
        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        LinkedListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        LinkedListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        LinkedListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}
