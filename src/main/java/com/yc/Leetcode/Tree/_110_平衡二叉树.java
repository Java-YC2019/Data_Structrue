package com.yc.Leetcode.Tree;

/**
 * 判断是否为高度平衡的二叉树
 *
 * @Author: yc
 * @Date: 2019/9/26 15:32
 * @Version 1.0
 */
public class _110_平衡二叉树 {


    boolean flag = false;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        maxDepth(root);
        return flag;

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);
        if (Math.abs(ldepth - rdepth) < 2) flag = true;
        if (Math.abs(ldepth - rdepth) > 1) flag = false;
        return Math.max(ldepth, rdepth) + 1;

    }
}
