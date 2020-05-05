package com.yc.MySolution;

/**
 * 1. Given an array of ints = [6, 4, -3, 5, -2, -1, 0, 1, -9],
 * implement a function to move all positive numbers to the left, and move all negative numbers to the right.
 * Try your best to make its time complexity to O(n), and space complexity to O(1)
 * 该题属于荷兰国旗问题，采用3指针控制范围解答可满足条件
 */
public class MySolution2 {
    public static void main(String[] args) {
        int[] a = {6, 4, -3, 5, -2, -1, 0, 1, -9};
        sortNums(a);
        for (int i : a) {
            System.out.println(i);
        }
    }


    public static void sortNums(int[] nums) {
        int len = nums.length;

        // all in [0, zero) < 0
        // all in [zero, i) = 0
        // all in [two, len - 1] > 0

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two

        int zero = 0;

        int two = len;

        int i = 0;

        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two

        while (i < two) {
            if (nums[i] < 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 0) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
