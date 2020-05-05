package com.yc.Leetcode.Array;

/**
 * 数组中元素与下一个比它大的元素之间的距离
 * <p>
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]
 *
 * @Author: yc
 * @Date: 2019/9/27 16:59
 * @Version 1.0
 */
public class _739_每日温度 {
    /**
     * 暴力破解法
     * @param T
     * @return
     */
//    public int[] dailyTemperatures(int[] T) {
//        int[] a =new int[T.length];
//        for (int i = 0; i < T.length; i++) {
//            int index=0;
//            for (int j = i; j <T.length; j++) {
//                if (T[i]<T[j]){
//                    index=j-i;
//                    break;
//                }
//            }
//            a[i]=index;
//        }
//        return a;
//    }

    /**
     * 1.从后往前遍历，最后一个肯定是0，之后的每一个数与它后面的一个数比较，如果比它后面的数小，直接就是1
     * 2.如果比它后面的数大并且后面的数的距离为0，就是0，
     * 3.如果比它后面的数大并且后面的一个数的距离不等于0，则比较当前数和比后面一位数大的第一个数
     * 4.在第3步的基础上：当前数比后面的大，距离为两处索引相减
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {

        int[] days = new int[T.length];
        days[days.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                days[i] = 1;
            } else {
                if (days[i + 1] == 0) {
                    days[i] = 0;
                } else {
                    int m = i + 1;
                    int idx = T[m];
                    while (T[i] >= idx && days[m] != 0) {
                        m = m + days[m];
                        idx = T[m];
                    }
                    days[i] = T[i] < idx ? m - i : 0;
                }
            }

        }
        return days;
    }

    //大神代码
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

}
