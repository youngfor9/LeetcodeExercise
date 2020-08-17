package part1.sidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode链接：https://leetcode.com/problems/fruit-into-baskets/
 *In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 *
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
        int[] arr = {1, 6, 3, 2, 1, 3, 9};
        int i = mostFruits(arr, 2);
        System.out.println(i);
    }

    public static int mostFruits(int[] arr, int k) {
        int length = arr.length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>(length);
        int max = 0, index = 0;
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> integers = map.get(map.get(arr[i]));
            if (null == integers) {
                list.add(i);
                map.put(arr[i], list);
            }
            int size = integers.size();
            if (size + 1 == k) {
                max = Math.max(max, list.get(size) - index);
                index = list.get(0) + 1;
            }
        }
        return 1;
    }
}
