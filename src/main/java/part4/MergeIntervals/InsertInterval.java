package part4.MergeIntervals;

import org.junit.Test;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    @Test
    public void init() {//1-17
        int[][] intervals = {{1, 5}, {15, 20}, {21, 25}, {26, 30}};
        int[] newInterval = {5, 17};
        int[][] insert = insert(intervals, newInterval);
        System.out.println(insert);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int[] temp = newInterval;
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] > temp[1]){
                res.add(temp);
                temp = intervals[i];
            }else if(intervals[i][1] < temp[0]){
                res.add(intervals[i]);
            }/*else if (intervals[i][0] <= temp[0] && intervals[i][1] < temp[1]) {
                temp[0] = intervals[i][0];
                temp[1] = newInterval[1];
            } else if (intervals[i][0] > temp[0] && intervals[i][1] >= temp[1]) {
                temp[0] = temp[0];
                temp[1] = intervals[i][1];
            }*/
            //改造版
            else{
                temp[0] = Math.min(intervals[i][0], temp[0]);
                temp[1] = Math.max(intervals[i][1], temp[1]);

            }
        }
        res.add(temp);
        return res.toArray(new int[res.size()][]);
    }

}
