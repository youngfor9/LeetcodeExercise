package part5.ReversalOfLinkedList;

import org.junit.Test;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * <p>
 * <p>
 * 指定n到m的反转
 */
public class ReverseLinkedListII {
    @Test
    public void init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode listNode = reverseBetween(node1, 2, 4);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur = head.next, pre = null, temp = null, mNode = head;
        int i = 2;
        while (i < n + 1) {
            if (m <= i) {
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            } else if (i == m - 1) {
                mNode = cur;
                cur = cur.next;
            }
            i++;
        }
        temp = mNode.next;
        mNode.next = pre;
        temp.next = cur;
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
