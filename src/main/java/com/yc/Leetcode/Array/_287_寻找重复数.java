package com.yc.Leetcode.Array;

/**
 * 寻找数组中的重复数
 * 二分查找
 * 快慢指针
 *
 * @Author: yc
 * @Date: 2019/9/30 9:29
 * @Version 1.0
 */
public class _287_寻找重复数 {
    //快慢指针
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    /**
     * 二分查找
     * 使用二分法查找的时候注意边界问题
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
//        System.out.println("low=" + low + "    high = " + high);
        int index = 1;
        while (low < high) {
            int mid = (low + high) / 2;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
//            System.out.println("第" + index++ + "轮查找:" + "mid=" + mid + "     low=" + low + "   high=" + high);
        }
        return low;
    }

    public static int findDuplicate3(int[] nums) {
        int l = 1, h = nums.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) cnt++;
            }
            if (cnt >= mid) h = mid - 1;
            else l = mid + 1;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 4, 5, 6, 7};
        System.out.println(findDuplicate2(a));
        System.out.println(findDuplicate3(a));
    }
}
