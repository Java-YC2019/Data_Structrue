package com.yc.Leetcode.Tree;

/**
 * 直径等于左右子树的高度相加；
 */

public class _543_二叉树的直径 {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        int depth =  depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        max = Math.max(L + R, max);
        int depth = Math.max(L, R) + 1;
        return depth;
    }
}
