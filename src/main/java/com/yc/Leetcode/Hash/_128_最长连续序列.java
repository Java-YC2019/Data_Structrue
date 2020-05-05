package com.yc.Leetcode.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * @Author: yc
 * @Date: 2019/10/15 12:40
 * @Version 1.0
 */
public class _128_最长连续序列 {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        int count = 0;
        for (Integer num : map.keySet()) {
            if (map.get(num) != -1) {
                int temp = num + 1;
                while (map.containsKey(temp)) {
                    map.put(temp, -1);
                    temp++;
                }
                count = Math.max(count, temp - num);
            }
        }
        return count;
    }

    //较优解法
    public static int longestConsecutive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : nums) {

            if (set.remove(num)) {
                int cur = num;
                while (set.remove(cur - 1)) {
                    cur--;
                }
                int temp1 = num - cur;
                cur = num;
                while (set.remove(cur + 1)) {
                    cur++;
                }
                int temp2 = cur - num;
                max = Math.max(max, temp1 + temp2 + 1);
            }
        }
        return max;
    }

    //大神解法1
    public int longestConsecutive3(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, 1);
        }
        for (int num : nums) {
            forward(countForNum, num);
        }
        return maxCount(countForNum);
    }

    private int forward(Map<Integer, Integer> countForNum, int num) {
        if (!countForNum.containsKey(num)) {
            return 0;
        }
        int cnt = countForNum.get(num);
        if (cnt > 1) {
            return cnt;
        }
        cnt = forward(countForNum, num + 1) + 1;
        countForNum.put(num, cnt);
        return cnt;
    }

    private int maxCount(Map<Integer, Integer> countForNum) {
        int max = 0;
        for (int num : countForNum.keySet()) {
            max = Math.max(max, countForNum.get(num));
        }
        return max;
    }

    //解法2
    public static int longestConsecutive4(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //已经考虑过的数字就跳过，必须跳过，不然会出错
            //比如 [1 2 1]
            //最后的 1 如果不跳过，因为之前的 2 的最长长度已经更新成 2 了，所以会出错
            if (map.containsKey(num)) {
                continue;
            }
            //找到以左边数字结尾的最长序列，默认为 0
            int left = map.getOrDefault(num - 1, 0);
            //找到以右边数开头的最长序列，默认为 0
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + 1 + right;
            max = Math.max(max, sum);
            //将当前数字放到 map 中，防止重复考虑数字，value 可以随便给一个值
            map.put(num, -1);
            //更新左边界长度
            map.put(num - left, sum);
            //更新右边界长度
            map.put(num + right, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[]{100, 4, 200, 1, 3, 2};
//        System.out.println(new Solution128().longestConsecutive3(a));
        System.out.println(longestConsecutive2(a));
    }
}
