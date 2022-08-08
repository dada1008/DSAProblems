/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (37.99%)
 * Likes:    17819
 * Dislikes: 3684
 * Total Accepted:    2.7M
 * Total Submissions: 7M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        ListNode result = null;
        ListNode resultNext = null;
        int extra = 0;
        while(l1Next!=null && l2Next!=null) {
            int sum = l1Next.val + l2Next.val + extra;
            if(sum > 9) {
                extra = sum/10;
                sum = sum%10;
            } else {
                extra = 0;
            }
            if(result==null) {
                result = new ListNode(sum);
                resultNext = result;
            } else {
                resultNext.next = new ListNode(sum);
                resultNext = resultNext.next;
            }
            l1Next = l1Next.next;
            l2Next = l2Next.next;            
        }
        while(l1Next!=null) {
            int sum = l1Next.val+ extra;
            if(sum > 9) {
                extra = sum/10;
                sum = sum%10;
            } else {
                extra = 0;
            }
            if(result==null) {
                result = new ListNode(sum);
                resultNext = result;
            } else {
                resultNext.next = new ListNode(sum);
                resultNext = resultNext.next;
            }
            l1Next = l1Next.next;          
        }
        while(l2Next!=null) {
            int sum = l2Next.val+ extra;
            if(sum > 9) {
                extra = sum/10;
                sum = sum%10;
            } else {
                extra = 0;
            }
            if(result==null) {
                result = new ListNode(sum);
                resultNext = result;
            } else {
                resultNext.next = new ListNode(sum);
                resultNext = resultNext.next;
            }
            l2Next = l2Next.next;          
        }
        if(extra > 0) {
            resultNext.next = new ListNode(extra);
        }
        return result;
    }
}
// @lc code=end

