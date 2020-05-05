package com.yc.Leetcode.Array;

/**
 * 求最大连续的1
 * @Author: yc
 * @Date: 2019/9/25 18:18
 * @Version 1.0
 */
public class _485_最大连续1的个数 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int index = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                index++;
            } else {
                if (index > count) {

                    count = index;
                }
                index = 0;
            }
        }
        return Math.max(index, count);
    }
    //大神代码
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a={1,1,1,1,1};
//        int[] a={1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(a.length);
        System.out.println(new _485_最大连续1的个数().findMaxConsecutiveOnes(a));

    }

}
