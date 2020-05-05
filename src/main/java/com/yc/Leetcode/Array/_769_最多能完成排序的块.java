package com.yc.Leetcode.Array;

/**
 * 题目描述：分隔数组，使得对每部分排序后数组就为有序。
 *
 * @Author: yc
 * @Date: 2019/10/10 15:46
 * @Version 1.0
 */
public class _769_最多能完成排序的块 {
    /**
     * 可分块的条件
     * 当遍历到第i个位置时，如果可以切分为块，那前i个位置的最大值一定等于i。
     * 否则，一定有比i小的数划分到后面的块，那块排序后，一定不满足升序。
     *
     * @param arr
     * @return
     */
    public static int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max)
                res++;
        }
        return res;
    }
}
