package part6.TreeBreadthFirstSearch;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 */
public class MinimumDepthOfBinaryTree extends BinaryTreeInfo {
    @Test
    public void init() {
        int i = minDepth(super.build());
        System.out.println(i);
    }

    /**
     * BFS
     */
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (null != cur.left) {
                    queue.add(cur.left);
                }
                if (null != cur.right) {
                    queue.add(cur.right);
                }
                if (queue.size() + i + 1 == size) {
                    return level;
                }
            }
            level++;
        }
        return level;
    }
}
