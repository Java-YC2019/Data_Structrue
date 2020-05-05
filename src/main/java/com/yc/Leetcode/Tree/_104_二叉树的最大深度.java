package com.yc.Leetcode.Tree;

/**
 * 求二叉树的最大深度
 *
 * @Author: yc
 * @Date: 2019/9/26 14:59
 * @Version 1.0
 */
public class _104_二叉树的最大深度 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
