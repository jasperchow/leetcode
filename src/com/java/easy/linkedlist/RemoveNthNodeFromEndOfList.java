//Given linked list: 1->2->3->4->5, and n = 2.
//
//        After removing the second node from the end, the linked list becomes 1->2->3->5.

package com.java.easy.linkedlist;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}




public class RemoveNthNodeFromEndOfList {

    public RemoveNthNodeFromEndOfList(){}

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while(first != null){
            length += 1;
            first = first.next;
        }
        first = dummy;
        length -= n;
        while (length > 0){
            first = first.next;
            length -= 1;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
