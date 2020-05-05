package com.yc.Leetcode.Tree;

public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


//    public boolean isSymmetric(TreeNode root) {
//        TreeNode[] nodes = new TreeNode[]{root};
//        return isSymmetric(nodes);
//    }
//
//    public boolean isSymmetric(TreeNode[] nodes) {
//        boolean flag = true;
//        for (TreeNode node : nodes) {
//            if (node != null) {
//
//                flag = false;
//                break;
//            }
//        }
//        if (flag) return true;
//        int left = 0;
//        int right = nodes.length-1;
//        while (left <= right) {
//            if (nodes[left] == null && nodes[right] == null) {
//                left++;
//                right--;
//            } else if (nodes[left] == null || nodes[right] == null) {
//                return false;
//            } else {
//                if (nodes[left].val != nodes[right].val) return false;
//                else {
//                    left++;
//                    right--;
//                }
//            }
//
//        }
//        TreeNode[] newNodes = new TreeNode[nodes.length * 2];
//        for (int i = 0; i < nodes.length; i++) {
//            if (nodes[i] != null) {
//                newNodes[i*2] = nodes[i].left;
//                newNodes[i*2 + 1] = nodes[i].right;
//            }else {
//                newNodes[i*2] = null;
//                newNodes[i*2 + 1] = null;
//            }
//        }
//        return isSymmetric(newNodes);
//    }
}
