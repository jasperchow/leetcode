//Given a singly linked list, determine if it is a palindrome.
//
//        Example 1:
//
//        Input: 1->2
//        Output: false
//        Example 2:
//
//        Input: 1->2->2->1
//        Output: true
//        Follow up:
//        Could you do it in O(n) time and O(1) space?

package com.java.easy.linkedlist;

public class PalindromeLinkedList {
    public PalindromeLinkedList(){}

    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode endOfFirstHalf = endOfFirstHalf(head);
        ListNode endOfSecondHalf = reverseList(endOfFirstHalf.next);

        ListNode p1 = head;
        ListNode p2 = endOfSecondHalf;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        endOfFirstHalf.next = reverseList(endOfSecondHalf);

        return result;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
