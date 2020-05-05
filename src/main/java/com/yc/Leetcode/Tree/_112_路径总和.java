package com.yc.Leetcode.Tree;

public class _112_路径总和 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum = sum - root.val;
//        if (sum < 0) return false; 路径可能为负数，所以该条件不能成立
//        if (sum == 0) {
//            return root.left == null && root.right == null;
//        }  当sum=0时，可能该节点是非叶子节点，会直接返回false，然而可能在其子树的叶子节点中成立
        if (root.left == null && root.right == null && sum == 0) return true;
        return (hasPathSum(root.left, sum) || hasPathSum(root.right, sum));
    }

}
