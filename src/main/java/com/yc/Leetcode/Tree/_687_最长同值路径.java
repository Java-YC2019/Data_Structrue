package com.yc.Leetcode.Tree;

public class _687_最长同值路径 {
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int L = dfs(root.left);
        int R = dfs(root.right);
        int leftPath = root.left != null && root.left.val == root.val ? L + 1 : 0;
        int rightPath = root.right != null && root.right.val == root.val ? R + 1 : 0;
        max = Math.max(leftPath + rightPath, max);
        return Math.max(leftPath, rightPath);
    }
}
