package com.yc.Leetcode.Tree;


/**
 * 递归实现，计算从根节点出发的满足的个数，然后计算从左右子节点出发满足的
 */
public class _437_路径总和_III {
    //优化方法
    public int pathSum1(TreeNode root, int sum) {
        return pathSum(root, sum, new int[1000], 0);
    }

    public int pathSum(TreeNode root, int sum, int[] trees, int deep) {
        if (root == null) return 0;
        trees[deep] = root.val;
        int temp = 0;
        int cur = 0;
        for (int i = deep; i >= 0; i--) {
            temp += trees[i];
            if (temp == sum) cur++;
        }
        return cur + pathSum(root.left, sum, trees, deep + 1) + pathSum(root.right, sum, trees, deep + 1);
    }

    //效率不高，有大量重复计算
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int result = 0;
        sum = sum - root.val;
        if (sum == 0) result++;
        result += pathSumStartWithRoot(root.left, sum) + pathSumStartWithRoot(root.right, sum);
        return result;
    }
}
