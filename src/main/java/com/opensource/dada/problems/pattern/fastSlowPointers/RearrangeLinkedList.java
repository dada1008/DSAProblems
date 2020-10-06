package com.opensource.dada.problems.pattern.fastSlowPointers;

import com.opensource.dada.ds.list.LinkedListNode;

/**
 * Problem:
 * Given the head of a Singly LinkedList, write a method to modify the LinkedList such that
 * the nodes from the second half of the LinkedList are inserted alternately to the nodes from
 * the first half in reverse order. So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null,
 * your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
 *
 * Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
 *
 * Example 1:
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
 * Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
 * Example 2:
 *
 * Input: 2 -> 4 -> 6 -> 8 -> 10 -> null
 * Output: 2 -> 10 -> 4 -> 8 -> 6 -> null
 */
public class RearrangeLinkedList {
    public static void main(String[] args) {
        test1();
        test2();
    }
    static void test1() {
        LinkedListNode root = new LinkedListNode(2);
        LinkedListNode four = new LinkedListNode(4);
        LinkedListNode six = new LinkedListNode(6);
        LinkedListNode eight = new LinkedListNode(8);
        LinkedListNode ten = new LinkedListNode(10);
        LinkedListNode twelve = new LinkedListNode(12);
        root.next = four;
        four.next = six;
        six.next = eight;
        eight.next = ten;
        ten.next = twelve;
        reorder(root);
        LinkedListNode.print(root);
    }

    static void test2() {
        LinkedListNode root = new LinkedListNode(2);
        LinkedListNode four = new LinkedListNode(4);
        LinkedListNode six = new LinkedListNode(6);
        LinkedListNode eight = new LinkedListNode(8);
        LinkedListNode ten = new LinkedListNode(10);
        root.next = four;
        four.next = six;
        six.next = eight;
        eight.next = ten;
        reorder(root);
        LinkedListNode.print(root);
    }

    static void reorder(LinkedListNode node) {
        LinkedListNode slow=null, fast=null;
        slow = node;
        fast = node;
        //Find middle
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        LinkedListNode previous = null, next = null, current = slow;

        while (current!=null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        LinkedListNode revRoot = previous;
        LinkedListNode nextRev = null;
        while (revRoot!=null && node!=null) {
            next = node.next;
            node.next = revRoot;
            node = next;

            nextRev = revRoot.next;
            revRoot.next = node;
            revRoot = nextRev;
        }
        if (node!=null) {
            node.next = null;
        }

    }
}
