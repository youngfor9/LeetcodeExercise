package part4.MergeIntervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 * 合并重叠的部分
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 */
public class MergeIntervals {
    @Test
    public void init() {
        int[][] arr = {{1,5},{2,6},{15,20},{16,25},{17,30},{10,15}};
        int[][] merge = merge(arr);
        System.out.println(merge);
    }

    public int[][] merge(int[][] intervals) {
        //根据首字母排序
        Arrays.sort(intervals,(i,j)->Integer.compare(i[0],j[0]));
        List<int[]> result = new ArrayList<>();
        int len = intervals.length,j=0;
        int[] compare = intervals[0];
        for (int i = 1; i < len; i++) {
            int[] temp = intervals[i];
            if (compare[1] >= temp[0]) {
                compare = new int[]{compare[0], temp[1]};
            } else {
                result.add(compare);
                compare = temp;
            }
        }
        result.add(compare);
        return result.toArray(new int[result.size()][]);
    }

}
