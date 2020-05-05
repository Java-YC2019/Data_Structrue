package com.yc.Leetcode.Array;

import java.util.Arrays;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 */
public class _215_数组中的第K个最大元素 {
    private Random random = new Random();
    public static void main(String[] args) {
        //使用快速选择算法
        int[] nums = new int[]{4, 5, 6, 2, 3, 7};
        partition(nums, 0, 5);
        System.out.println(Arrays.toString(nums));
        new Random();


    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int index = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int position=  partition1(nums, left, right);
            if (index == position) {
                return nums[index];
            } else if (index > position) {
                left = position + 1;
            }else {
                right = position - 1;
            }
        }

    }

    public int partition1(int[] nums, int left, int right) {
        int pivot = left + random.nextInt(right - left + 1);
//        int pivot =  (left + (int)Math.random() * (right - left + 1));
        swap(nums, pivot, left);
        pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (true) {
            while (l <= r && nums[l] <= pivot) l++;
            while (l <= r && nums[r] >= pivot) r--;
            if (l > r) {
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, left, r);
        return r;
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;     //j指向大于等于pivot的元素的最近的一个
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            return find(nums, 0 , nums.length - 1, k);
        }

        private int find(int[] nums, int start, int end, int k) {
            if (k == 1) {
                int max = nums[start];
                for (int i = start+1; i <= end; i++) {
                    if (max < nums[i]) {
                        max = nums[i];
                    }
                }
                return max;
            } else if (k == end - start + 1) {
                int min = nums[start];
                for (int i = start+1; i <= end; i++) {
                    if (min > nums[i]) {
                        min = nums[i];
                    }
                }
                return min;
            }
            int left = start, right = end;

            int p = nums[left];
            while (left <= right) {
                while (left <= right && nums[left] >= p) {
                    left++;
                }
                while (right >= left && nums[right] < p) {
                    right--;
                }
                if (left < right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                } else {
                    break;
                }
            }
            if (left == end + 1) {  // p is min
                return find(nums, start + 1, end, k);
            }
            int firstN = left - start;
            if (firstN >= k) {
                return find(nums, start, left - 1, k);
            } else {
                return find(nums, left, end, k - firstN);
            }
        }
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public class Solution2 {

        private Random random = new Random(System.currentTimeMillis());

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;

            // 转换一下，第 k 大元素的索引是 len - k
            int target = len - k;

            while (true) {
                int index = partition(nums, left, right);
                if (index == target) {
                    return nums[index];
                } else if (index < target) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            }
        }

        public int partition(int[] nums, int left, int right) {
            // 在区间随机选择一个元素作为标定点
            if (right > left) {
                int randomIndex = left + 1 + random.nextInt(right - left);
                swap(nums, left, randomIndex);
            }

            int pivot = nums[left];

            // 将等于 pivot 的元素分散到两边
            // [left, lt) <= pivot
            // (rt, right] >= pivot

            int lt = left + 1;
            int rt = right;

            while (true) {
                while (lt <= rt && nums[lt] < pivot) {
                    lt++;
                }
                while (lt <= rt && nums[rt] > pivot) {
                    rt--;
                }

                if (lt > rt) {
                    break;
                }
                swap(nums, lt, rt);
                lt++;
                rt--;
            }

            swap(nums, left, rt);
            return rt;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

}
