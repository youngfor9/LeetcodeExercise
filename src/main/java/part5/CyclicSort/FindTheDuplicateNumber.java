package part5.CyclicSort;

import org.junit.Test;

/**
 *
 */
public class FindTheDuplicateNumber {

    @Test
    public void init() {
        int[] arr = {2, 5, 4, 1, 1, 3};
        int duplicate = findDuplicate(arr);
        System.out.println(duplicate);
    }

    /**
     * 还是利用快慢指针，快指针先进入到循环里与慢指针相遇，然后再从头开始，慢指针和快指针在循环起始点相遇。
     * 借鉴：https://leetcode.com/problems/find-the-duplicate-number/discuss/72845/Java-O(n)-time-and-O(1)-space-solution.-Similar-to-find-loop-in-linkedlist.
     */
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}


