package part1.sidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with K Equal Characters
 * 给定一个字符串，找到最多有k个不同字符的最长子字符串。
 * 例如，给定 s = "eceba" , k = 3,
 * T 是 "eceb"，长度为 4.
 * 挑战：时间复杂度是o(n)
 * @author young
 */
public class LongestSubWithkEqChar {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 2, 1, 3, 9};
        longestSubWithKunChar(arr, 2);
    }

    public static int longestSubWithKunChar(int[] arr, int k) {
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
