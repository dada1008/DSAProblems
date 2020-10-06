package com.opensource.dada.ds.list;

public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public static void print(LinkedListNode node) {
        while (node!=null) {
            System.out.print(node.value+"->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "value=" + value +
                '}';
    }
}
