package com.yc.Leetcode.Array;

import java.util.Arrays;

/**
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 * <p>
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 * <p>
 * ② 如果存在多种答案，你只需实现并返回其中任意一种.
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 1
 * 输出: [1, 2, 3]
 * 解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 3, k = 2
 * 输出: [1, 3, 2]
 * 解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
 *
 * @Author: yc
 * @Date: 2019/9/30 17:18
 * @Version 1.0
 */
//1 1+1 1+1+2 1+1+2+3 1+1+2+3+4
public class _667_优美的排列_II {
    public static int[] constructArray(int n, int k) {
//        int index = 1;
//        int[] numbs = new int[n];
//        for (int i = 0; i < k; i++) {
//            int temp = 0;
//            for (int j = 0; j < index; j++) {
//                temp = temp + j;
//            }
//            numbs[i] = 1 + temp;
//            index++;
//        }
//        for (int i = k; i < n; i++) {
//            numbs[i] = numbs[k - 1];
//        }
//        return numbs;
        int[] nums = new int[n];
        int idx1 = k + 1;
        int idx2 = 1;
        for (int i = 0; i < k + 1; i++) {
            nums[i] = i % 2 == 0 ? idx2++ : idx1--;
        }
        for (int i = k + 1; i < n; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] numbs = constructArray(5, 1);
        System.out.println(Arrays.toString(numbs));
    }
}
