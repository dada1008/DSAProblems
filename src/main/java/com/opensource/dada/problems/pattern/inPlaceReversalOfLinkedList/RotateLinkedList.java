package com.opensource.dada.problems.pattern.inPlaceReversalOfLinkedList;

import com.opensource.dada.ds.list.LinkedListNode;

/**
 * Problem:
 * Rotate a LinkedList
 * Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 * <p>
 * Example 1:
 * k=3
 * Original List:
 * 1->2->3->4->5->6->null
 * Rotated LinkedList:
 * 4->5->6->1->2->3->null
 * <p>
 * Example 2:
 * k=8
 * Original List:
 * 1->2->3->4->5->null
 * Rotated LinkedList:
 * 3->4->5->1->2->null
 */
public class RotateLinkedList {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node6 = new LinkedListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println("Before rotate:");
        LinkedListNode.print(node1);
        LinkedListNode reversedNode = rotate(node1, 3);
        System.out.println("After rotate:");
        LinkedListNode.print(reversedNode);
    }

    static void test2() {
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node5 = new LinkedListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("Before rotate:");
        LinkedListNode.print(node1);
        LinkedListNode reversedNode = rotate(node1, 8);
        System.out.println("After rotate:");
        LinkedListNode.print(reversedNode);
    }

    static LinkedListNode rotate(LinkedListNode head, int rotations) {
        LinkedListNode current = head;
        // find the length and the last node of the list
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        // connect the last node with the head to make it a circular list
        current.next = head;
        // no need to do rotations more than the length of the list
        rotations %= length;

        int skipLength = length - rotations;
        LinkedListNode lastNodeOfRotatedList = head;

        for (int i = 0; i < skipLength -1; i++) {
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }
        // 'lastNodeOfRotatedList.next' is pointing to the sub-list of 'k' ending nodes
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        return head;
    }
}
