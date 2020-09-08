package part6.TreeBreadthFirstSearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree extends BinaryTreeInfo {
    @Test
    public void init() {
        List<Double> doubles = averageOfLevels(super.build());
        System.out.println(doubles);
    }

    /**
     * BFS
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (null != cur.left) {
                    queue.add(cur.left);
                }
                if (null != cur.right) {
                    queue.add(cur.right);
                }
                sum += cur.val;
            }
            res.add(sum / size);
        }
        return res;
    }
}
