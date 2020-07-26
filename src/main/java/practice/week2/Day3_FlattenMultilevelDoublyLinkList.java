package practice.week2;

import practice.utility.Node;

public class Day3_FlattenMultilevelDoublyLinkList {

    public Node flatten(Node head) {
        if (head == null) return head;
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node down = curr.child;
                while (down.next != null) down = down.next;

                Node tmp = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                down.next = tmp;

                if (tmp != null) tmp.prev = down; // end case
            }
            curr = curr.next;
        }
        return head;
    }

}
