package com.opensource.dada.problems.pattern.fastSlowPointers;

/**
 * Problem: https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        test1();
        test2();
    }
    static void test1() {
        /**
         * Input: 1->2
         * Output: false
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        System.out.println("Is Palindrome:"+isPalindrome(node1));//false

    }

    static void test2() {
        /**
         * Input: 1->2->2->1
         * Output: true
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("Is Palindrome:"+isPalindrome(node1));//true

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow;
        if (pre != null) pre.next = null;
        p = reverse(p);

        while (head != null && p != null) {
            if (head.val != p.val) {
                return false;
            }
            head = head.next;
            p = p.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
