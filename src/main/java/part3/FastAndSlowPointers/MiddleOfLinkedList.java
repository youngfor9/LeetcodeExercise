package part3.FastAndSlowPointers;

import org.junit.Test;

/**
 * 找到Linkedlist的中间
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
