package com.opensource.dada.problems.leetcode;

public class AddTwoNumbersInLinkedList {

    public static void main(String[] args) {
        test1();
        test2();
    }
    public static void test1() {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l12;
        l12.next = new ListNode(3);
        traverse(l1);
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l2.next=l22;
        l22.next = new ListNode(4);
        traverse(l2);

        ListNode resultNode = addTwoNumbers(l1,l2);
        traverse(resultNode);
    }
    public static void test2() {
        ListNode l1 = new ListNode(5);
        traverse(l1);
        ListNode l2 = new ListNode(5);
        traverse(l2);

        ListNode resultNode = addTwoNumbers(l1,l2);
        traverse(resultNode);
    }
    static void traverse(ListNode node) {
        while (node!=null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
        System.out.println("null");
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        ListNode resultNode = null, nextNode = null;
        while (l1!=null || l2!=null) {
            int l1Val = 0, l2Val = 0;
            if(l1!=null) {
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2!=null) {
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + extra;
            if(sum>=10) {
                int reminder = sum % 10;
                extra = sum /10;
                sum = reminder;
            } else {
                extra = 0;
            }
            if(resultNode==null) {
                resultNode = new ListNode(sum);
                nextNode = resultNode;
            } else {
                ListNode node = new ListNode(sum);
                nextNode.next = node;
                nextNode = node;
            }
        }
        if(extra > 0) {
            ListNode node = new ListNode(extra);
            nextNode.next = node;
        }

        return resultNode;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
