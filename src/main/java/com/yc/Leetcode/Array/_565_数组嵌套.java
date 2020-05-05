package com.yc.Leetcode.Array;

/**
 * 题目描述：S[i] 表示一个集合，集合的第一个元素是 A[i]，
 * 第二个元素是 A[A[i]]，如此嵌套下去。求最大的 S[i]。
 *
 * @Author: yc
 * @Date: 2019/10/9 17:21
 * @Version 1.0
 */
public class _565_数组嵌套 {
    /**
     * 重复元素会形成环，而且一定是指向第一个元素
     *
     * @param nums
     * @return
     */
    public static int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int count = 0;
            if (start != -1) {
                do {
                    int pre = start;
                    start = nums[start];
                    count++;
                    nums[pre] = -1;
                } while (nums[start] != -1);
            }
            res = Math.max(count,res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A=new int[]{5,4,0,3,1,6,2};
        System.out.println(arrayNesting(A));
    }
}
