package com.yc.Leetcode.pointer;

public class _167_两数之和2_输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
       int left = 0, right = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            }else left++;
        }

        return new int[]{-1, -1};
    }
}
