package com.yc.Leetcode.Tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 */

public class _637_二叉树的层平均值 {

    // 广度优先搜索
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue  = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum / cnt);
        }
        return res;

    }

    // 深度优先搜索--官方题解
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }

    public void average(TreeNode t, int i, List<Double> sum, List<Integer> count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }

    public List<Double> averageOfLevels3(final TreeNode root) {

        return new java.util.AbstractList<Double>() {
            List<Double> doubleList = new ArrayList<Double>();
            boolean init = false;
            public void init() {
                Queue<TreeNode> nodeList = new LinkedList<TreeNode>();
                nodeList.add(root);
                while (!nodeList.isEmpty()) {
                    double count = 0.0;
                    int len = nodeList.size();
                    for(int i=0;i<len;i++){
                        TreeNode node = nodeList.poll();
                        count += node.val;
                        if (node.left != null) {
                            nodeList.add(node.left);
                        }
                        if (node.right != null) {
                            nodeList.add(node.right);
                        }
                    }
                    doubleList.add(count / len);
                }
                init = true;
            }

            @Override
            public int size() {
                if (!init) {
                    init();
                }
                return doubleList.size();
            }

            @Override
            public Double get(int index) {
                if (!init) {
                    init();
                }
                return doubleList.get(index);
            }
        };

    }

}


