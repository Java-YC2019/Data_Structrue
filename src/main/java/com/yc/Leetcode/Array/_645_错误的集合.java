package com.yc.Leetcode.Array;

import java.util.Arrays;

/**
 * 一个数组元素在 [1, n] 之间，
 * 其中一个数被替换为另一个数，找出重复的数和丢失的数
 * <p>
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 * @Author: yc
 * @Date: 2019/9/29 10:45
 * @Version 1.0
 */
public class _645_错误的集合 {
    /**
     * 直接方法，复杂
     * @param nums
     * @return
     */
//    public int[] findErrorNums(int[] nums) {
//        Arrays.sort(nums);
//        int[] res = new int[2];
//        int[] cur = new int[nums.length - 1];
//        int index = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i + 1]) {
//                res[0] = nums[i + 1];
//                i++;
//            }
//            cur[index++] = nums[i];
//        }
//        if (cur[cur.length - 1] == 0) {
//            cur[cur.length - 1] = nums[nums.length - 1];
//        }
//
//
//        for (int i = 0; i < cur.length; i++) {
//            if (cur[i] != i + 1 && res[1] == 0) {
//                res[1] = i + 1;
//            }
//        }
//        if (res[1] == 0) {
//            res[1] = nums.length;
//        }
//
//        return res;
//    }

    /**
     * hash方法,构建哈希函数
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        int[] hash = new int[10001];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if (hash[i] == 2) {
                res[1] = i;
            }
            if (hash[i] == 0) {
                res[0] = i;
            }
        }
        return res;
    }

    /**
     * 交换数组元素的方法
     * 抽屉原理
     *
     * @param nums
     * @return
     */
    public static int[] findErrorNums2(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
//                int temp = nums[i];
//                nums[i] = nums[nums[i] - 1];
//                nums[nums[i] - 1] = temp;
                //这样会出现死循环，因为nums[i]改变了，则nums[nums[i] - 1]的索引已经变得不是正确的了
                swap(nums, i, nums[i] - 1);
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9})));
        System.out.println(Arrays.toString(findErrorNums2(new int[]{3, 3, 2})));
    }
}
