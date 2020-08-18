package part1.sidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode链接：https://leetcode.com/problems/fruit-into-baskets/
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 * <p>
 * You start at any tree of your choice, then repeatedly perform the following steps:
 * <p>
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 * <p>
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 * <p>
 * What is the total amount of fruit you can collect with this procedure?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 * <p>
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 * <p>
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 * <p>
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 * 题目大意：
 * 一个数代表一种水果类型，一个篮子只能装一个水果，问给你两个篮子你最多装几个水果，前提是可以从任意位置开始装。
 * 和Longest Substring with K Distinct Characters思路一致
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 9, 9, 7, 5, 2};
        int i = mostFruits(arr, 2);
        System.out.println(i);
    }
    //答案借鉴：https://leetcode.com/problems/fruit-into-baskets/discuss/170740/JavaC%2B%2BPython-Sliding-Window-for-K-Elements
    public static int mostFruits(int[] arr, int k) {
        int begin = 0, end = 0, type = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < arr.length) {
            int in = arr[end++];
            if (map.getOrDefault(in, 0) == 0) type++;
            map.put(in, map.getOrDefault(in, 0) + 1);
            while (type > k) {
                int out = arr[begin++];
                if (map.put(out, map.get(out) - 1) == 1) type--;
            }
            max = Math.max(max, end - begin);
        }
        return max;
    }

}
