package DoublePoints;

import java.util.Arrays;

/**
 * 给定一个有序数组和一个目标和，在数组中找到一对和等于给定目标的数组，有就返回下标，没有就返回[-1,-1]。
 * <p>
 * 例如：
 * <p>
 * s=[1,2,3,4,5,6,7,8],k=14，返回[5,7]，也就是下标为5和下标为7的和为14：6+8=14。
 */
public class PairWithTargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 9, 10, 14, 17};
        int[] ints = pairWithTargetSum(arr, 15);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] pairWithTargetSum(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }
            if (sum == target) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

}
