package com.yc.Leetcode.Array;

/**
 * 题目描述：数组的度定义为元素出现的最高频率，例如上面的数组度为 3。
 * 要求找到一个最小的子数组，这个子数组的度和原数组一样。
 *
 * @Author: yc
 * @Date: 2019/10/9 11:53
 * @Version 1.0
 */
public class _697_数组的度 {
    //
    public static int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] left = new int[50000];
        int[] right = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (left[nums[i]] == 0 && nums[i] != nums[0]) left[nums[i]] = i;
            right[nums[i]] = i;
        }
        int degree = 0;
        int length = nums.length;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > degree) degree = count[i];
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == degree) length = Math.min(right[i] - left[i] + 1, length);
        }
        return length;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(a));
    }
}
