package part2.DoublePoints;

import java.util.Arrays;

/**
 * leetcode :https://leetcode.com/problems/squares-of-a-sorted-array/
 * <p>
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number,
 * also in sorted non-decreasing order.
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * <p>
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresOfStArray {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        int[] squares = squares(arr);
        System.out.println(Arrays.toString(squares));
    }


    private static int[] squares(int[] arr) {
        int len = arr.length, start = 0, end = len - 1, index = len - 1;
        int[] res = new int[len];
        while (start < end) {
            int startAbs = Math.abs(arr[start]);
            int endAbs = Math.abs(arr[end]);
            if (startAbs < endAbs) {
                res[index] = (int) Math.pow(endAbs, 2);
                end--;
            } else {
                res[index] = (int) Math.pow(startAbs, 2);
                start++;
            }
            index--;
        }
        return res;
    }
}
