package part1.sidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 等于目标值的最大长度。
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * <p>
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 * <p>
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 */
public class MaxSumSubarrayOfSK {
    public static void main(String[] args) {
        int[] nums = {-2, -1, 2, 1};
        int k = 1;
        System.out.println(test(nums, k));
    }

    public static int test(int[] nums, int k) {
        int length = nums.length, sum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //设置-1是为了索引为0的值等于k的情况设置的。
        map.put(0, -1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            System.out.println();
        }
        return res;
    }
}
