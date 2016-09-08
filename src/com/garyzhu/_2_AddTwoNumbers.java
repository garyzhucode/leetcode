package com.garyzhu;

/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode p = head, p1 = l1, p2 = l2;
        int a, b, c;
        int carry = 0;
        while (p1 != null || p2 != null) {
            a = (p1 != null) ? p1.val : 0;
            b = (p2 != null) ? p2.val : 0;
            c = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;

            ListNode p0 = new ListNode(c);
            p.next = p0;
            p = p.next;

            if (p1.next != null) {
                p1 = p1.next;
            } else {
                p1 = null;
            }
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                p2 = null;
            }
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
