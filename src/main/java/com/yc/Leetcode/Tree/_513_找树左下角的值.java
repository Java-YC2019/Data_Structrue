package com.yc.Leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/description/
 */


public class _513_找树左下角的值 {
    private int maxDepth = -1;
    private int value = 0;

    // 第一种思路：用队列进行层序遍历，右子树在左子树之前遍历，
    // 最后访问的一个节点就是
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }
        return root.val;

    }

    // 第二种思路：用递归+dfs，只要保证先遍历到左子节点，dfs深度优先搜索
    public int findBottomLeftValue2(TreeNode root) {
        dfs(root, 0);
        return value;
    }

    private void dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (i > maxDepth) {
            maxDepth = i;
            value = root.val;
        }
        dfs(root.left, i + 1);
        dfs(root.right, i + 1);

    }

}
