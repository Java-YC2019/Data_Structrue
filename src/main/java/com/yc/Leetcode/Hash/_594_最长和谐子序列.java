package com.yc.Leetcode.Hash;

import java.util.HashMap;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，
 * 你需要在所有可能的子序列中找到最长的和谐子序列的长度
 * <p>
 * 示例 1:
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 *
 * @Author: yc
 * @Date: 2019/10/15 10:42
 * @Version 1.0
 */
public class _594_最长和谐子序列 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                max = Math.max(map.get(num + 1) + map.get(num), max);
            }
            //不能这样写,当某个num的value和max一样的时候，会将max重置为0；
//            max = Math.max(map.getOrDefault(num + 1, 0) + map.get(num), max);
//            if (max == map.get(num)) {
//                max = 0;
//            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 2, 3, 6, 6, 6, 6};
        System.out.println(new _594_最长和谐子序列().findLHS(a));
    }
}
