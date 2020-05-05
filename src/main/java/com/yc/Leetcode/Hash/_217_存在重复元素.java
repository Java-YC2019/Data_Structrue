package com.yc.Leetcode.Hash;

import java.util.HashSet;

/**
 * 判断数组中是否存在重复的元素
 * @Author: yc
 * @Date: 2019/10/15 9:39
 * @Version 1.0
 */
public class _217_存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size()<nums.length;
    }
}
