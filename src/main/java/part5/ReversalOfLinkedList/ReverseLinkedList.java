package part5.ReversalOfLinkedList;

import org.junit.Test;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 反转链表
 */
public class ReverseLinkedList {
    @Test
    public void init() {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
