//Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
//
//        Example:
//
//        Input: 1->2->4, 1->3->4
//        Output: 1->1->2->3->4->4

package com.java.easy.linkedlist;

public class MergeTwoSortedLists {
    public MergeTwoSortedLists(){
    }
    public ListNode mergeTwoLists_recursion(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        else if(l1.val < l2.val){
            l1.next = this.mergeTwoLists_recursion(l1.next, l2);
            return l1;
        }
        else{
            l2.next = this.mergeTwoLists_recursion(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_iteration(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode previous = result;
        while ( l1 != null && l2!= null){
            if(l1.val < l2.val){
                previous.next = l1;
                l1 = l1.next;
            }
            else{
                previous.next = l2;
                l2 = l2.next;
            }
            previous = previous.next;
        }

        previous.next = l1 == null ? l2 : l1;

        return result.next;
    }
}
