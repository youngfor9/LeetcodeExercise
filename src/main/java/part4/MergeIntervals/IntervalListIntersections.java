package part4.MergeIntervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 取出2个数组的交集
 * https://leetcode.com/problems/interval-list-intersections/
 */

public class IntervalListIntersections {

    @Test
    public void init() {
        int[][] a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ints = intervalIntersection(a, b);
        System.out.println(ints);
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aLen = A.length;
        int bLen = B.length;

        int[][] ab = new int[aLen + bLen][];
        int maxLen = Math.max(aLen, bLen);
        //合并a和b
        for (int i = 0, j = 0; i < maxLen; i++) {
            if (i < aLen) {
                ab[j] = A[i];
                j++;
            }
            if (i < bLen) {
                ab[j] = B[i];
                j++;
            }
        }
        //排序
        Arrays.sort(ab, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] temp = ab[0];
        for (int i = 1; i < ab.length; i++) {
            if (temp[1] <= ab[i][0]) {
                if (temp[1] == ab[i][0]) res.add(new int[]{temp[1], temp[1]});
                temp = ab[i];
            } else {
                res.add(new int[]{ab[i][0], Math.min(temp[1], ab[i][1])});
                temp = temp[1] > ab[i][1] ? temp : ab[i];
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    //答案链接：https://leetcode.com/problems/interval-list-intersections/discuss/231122/Java-two-pointers-O(m-%2B-n)
    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return new int[][]{};
        List<int[]> res = new ArrayList<>();

        int i = 0, j = 0;
        int startMax, endMin;
        while(i < A.length && j < B.length){
            startMax = Math.max(A[i][0], B[j][0]);
            endMin = Math.min(A[i][1], B[j][1]);

            if(endMin >= startMax)
                res.add(new int[]{startMax, endMin});

            if(A[i][1] == endMin) i++;
            if(B[j][1] == endMin) j++;
        }

        return res.toArray(new int[res.size()][2]);
    }
}
