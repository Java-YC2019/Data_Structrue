package com.yc.Leetcode.Tree;

public class _404_左叶子之和 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);

    }
    public boolean isLeaf(TreeNode node) {
        if (node == null) return false;
        return node.left == null && node.right == null;
    }
}
