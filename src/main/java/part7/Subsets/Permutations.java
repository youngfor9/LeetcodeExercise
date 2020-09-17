package part7.Subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * https://leetcode.com/problems/permutations/
 * 给由不同数字组成的数组，返回所有可能的排列
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    @Test
    public void init() {
        int[] arr = {1, 2, 3,4};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, list, res);
        return res;
    }

    //借鉴：https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)
    public void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}
