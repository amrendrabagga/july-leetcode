package practice.week3;

import practice.utility.ListNode;

public class Day6_DeleteMultipleNodeInLinkList {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head != null && head.val == val) {// if list 6->6->6->6 k=6
            head = head.next;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            }
            else
                prev = curr;
            curr = curr.next;
        }
        return head;
    }
}
