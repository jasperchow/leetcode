import java.util.HashSet;

public class LinkedListCycle {
    public LinkedListCycle(){}

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> seen = new HashSet<>();

        while (head != null){
            if(seen.contains(head)){
                return true;
            }
            else {
                seen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
