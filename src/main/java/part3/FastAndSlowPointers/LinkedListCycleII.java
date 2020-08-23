package part3.FastAndSlowPointers;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 检查链表是不是循环列表，并且找出循环下标
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * <p>
 * Example 2:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycleII {
    //借鉴：https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.

    /**
     * a+b+x=2(a+b);
     * x=a+b;
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head.next, fast = head.next.next;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = head;
                //slow和slow2会在循环点相遇
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}

