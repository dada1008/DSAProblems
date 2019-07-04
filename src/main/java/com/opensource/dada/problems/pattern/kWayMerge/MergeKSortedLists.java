package com.opensource.dada.problems.pattern.kWayMerge;

import com.opensource.dada.ds.list.LinkedListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
 *          https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        /**
         * Input:
         * [
         *   1->4->5,
         *   1->3->4,
         *   2->6
         * ]
         * Output: 1->1->2->3->4->4->5->6
         */
        LinkedListNode firstList1 = new LinkedListNode(1);
        LinkedListNode firstList2 = new LinkedListNode(4);
        LinkedListNode firstList3 = new LinkedListNode(5);
        firstList1.next=firstList2;
        firstList2.next=firstList3;

        LinkedListNode secondList1 = new LinkedListNode(1);
        LinkedListNode secondList2 = new LinkedListNode(3);
        LinkedListNode secondList3 = new LinkedListNode(4);
        secondList1.next=secondList2;
        secondList2.next=secondList3;

        LinkedListNode thirdList1 = new LinkedListNode(2);
        LinkedListNode thirdList2 = new LinkedListNode(6);
        thirdList1.next=thirdList2;

        LinkedListNode mergedNode = mergeKLists(new LinkedListNode[]{firstList1, secondList1, thirdList1});
        LinkedListNode.print(mergedNode);
    }

    static void test2() {
        /**
         * list1 = 1->3->5->7->NULL
         * list2 = 2->4->6->8->NULL
         * list3 = 0->9->10->11
         *
         * Output:
         * 0->1->2->3->4->5->6->7->8->9->10->11
         */
        LinkedListNode firstList1 = new LinkedListNode(1);
        LinkedListNode firstList2 = new LinkedListNode(3);
        LinkedListNode firstList3 = new LinkedListNode(5);
        LinkedListNode firstList4 = new LinkedListNode(7);
        firstList1.next=firstList2;
        firstList2.next=firstList3;
        firstList3.next=firstList4;

        LinkedListNode secondList1 = new LinkedListNode(2);
        LinkedListNode secondList2 = new LinkedListNode(4);
        LinkedListNode secondList3 = new LinkedListNode(6);
        LinkedListNode secondList4 = new LinkedListNode(8);
        secondList1.next=secondList2;
        secondList2.next=secondList3;
        secondList3.next=secondList4;

        LinkedListNode thirdList1 = new LinkedListNode(0);
        LinkedListNode thirdList2 = new LinkedListNode(9);
        LinkedListNode thirdList3 = new LinkedListNode(10);
        LinkedListNode thirdList4 = new LinkedListNode(11);
        thirdList1.next=thirdList2;
        thirdList2.next=thirdList3;
        thirdList3.next=thirdList4;

        LinkedListNode mergedNode = mergeKLists(new LinkedListNode[]{firstList1, secondList1, thirdList1});
        LinkedListNode.print(mergedNode);
    }

    public static LinkedListNode mergeKLists(LinkedListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<LinkedListNode> queue = new PriorityQueue<>(Comparator.comparing(node -> node.value));

        for (LinkedListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode p = head;
        while (!queue.isEmpty()) {
            LinkedListNode n = queue.poll();
            p.next = n;
            p = p.next;

            if (n.next != null) {
                queue.offer(n.next);
            }
        }
        return head.next;
    }
}
