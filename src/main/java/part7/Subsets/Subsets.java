package part7.Subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * 求子集
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {
    @Test
    public void init() {
        int[] arr ={2,3,6,1};
        List<List<Integer>> subsets = subsets(arr);
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    //借鉴：https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    private void backtrack(List<List<Integer>> list, ArrayList<Integer> temp, int[] nums, int i) {
        list.add(new ArrayList(temp));
        for (int j = i; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(list, temp, nums, j + 1);
            temp.remove(temp.size()-1);
        }
    }


}
