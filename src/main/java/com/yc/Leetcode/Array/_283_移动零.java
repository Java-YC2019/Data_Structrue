package com.yc.Leetcode.Array;

/**
 * 将数组中的0移到最后
 * * @Author: yc
 * @Date: 2019/9/25 17:31
 * @Version 1.0
 */
public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        int idx=0;
        for (int i : nums) {
            if (i!=0) nums[idx++]=i;
        }
        while (idx<nums.length) nums[idx++]=0;
    }

    public void moveZeroes2(int[] nums) {
        
        int idx=0;
        for (int i : nums) {
            if (i!=0) nums[idx++]=i;
        }
        while (idx<nums.length) nums[idx++]=0;
    }

}
