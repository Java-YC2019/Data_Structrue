package com.yc.Leetcode.Hash;

import java.util.HashMap;

/**
 * 两数之和
 *
 * @Author: yc
 * @Date: 2019/9/27 11:18
 * @Version 1.0
 */
public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
