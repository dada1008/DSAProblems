package com.opensource.dada.ds.list;

import java.util.Stack;

public class InsertionSortUsingLinkedList {
    public static void main(String[] agrs) {
        Node node34 = new Node(34);
        Node node3 = new Node(3);
        Node node31 = new Node(31);
        Node node98 = new Node(98);
        Node node92 = new Node(92);
        Node node23 = new Node(23);

        node34.next = node3;
        node3.next = node31;
        node31.next = node98;
        node98.next = node92;
        node92.next = node23;

        Node input = node34;
        //Traverse before sort
        traverse(input);

        Node sorted = sortList(input);

        //Traverse after sort
        traverse(sorted);

    }

    public static Node sortList(Node input) {
        if (input == null || input.next == null)
            return input;

        Node newHead = new Node(input.value);
        Node pointer = input.next;

        // loop through each element in the list
        while (pointer != null) {
            // insert this element to the new list

            Node innerPointer = newHead;
            Node next = pointer.next;

            if (pointer.value <= newHead.value) {
                Node oldHead = newHead;
                newHead = pointer;
                newHead.next = oldHead;
            } else {
                while (innerPointer.next != null) {

                    if (pointer.value > innerPointer.value && pointer.value <= innerPointer.next.value) {
                        Node oldNext = innerPointer.next;
                        innerPointer.next = pointer;
                        pointer.next = oldNext;
                    }

                    innerPointer = innerPointer.next;
                }

                if (pointer.value > innerPointer.value) {
                    innerPointer.next = pointer;
                    pointer.next = null;
                }
            }

            // finally
            pointer = next;
        }

        return newHead;
    }

    public static void traverse(Node input) {
        Node node = input;
        while (node!=null) {
            System.out.print(node.value+" ");
            node = node.next;
        }
        System.out.print("\n");
    }

    static class Node {
        Node next;
        Integer value;

        public Node(Integer value) {
            this.value = value;
        }
    }
}
