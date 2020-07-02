//Reverse a singly linked list.
//
//        Example:
//
//        Input: 1->2->3->4->5->NULL
//        Output: 5->4->3->2->1->NULL

package com.java.easy.linkedlist;

public class ReverseLinkedList {
    public ReverseLinkedList(){}

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }
}
