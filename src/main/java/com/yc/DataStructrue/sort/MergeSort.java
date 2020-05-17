package com.yc.DataStructrue.sort;

/**
 * 归并排序
 */
@SuppressWarnings("ManualArrayCopy")
public class MergeSort {
    public int[] array;
    public int[] leftArray;

    public void sort(int[] Array) {
        array = Array;
        leftArray = new int[array.length >> 1];
        sort(0, array.length);
    }

    public void sort(int begin, int end) {
        if ((end - begin) < 2) {
            return;
        }
        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     */
    public void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;

        for (int i = 0; i < le; i++) {
            leftArray[i] = array[begin + i];
        }

//        while (li < le) {
//            if (ri < re && array[ri] < leftArray[li]) {// 换成<=会破坏稳定性
//                array[ai++] = array[ri++];
//            } else {
//                array[ai++] = leftArray[li++];
//            }
//        }

//        while (li < le) {
//            if (ri == re || array[ri] >= leftArray[li]) {
//                array[ai++] = leftArray[li++];
//
//            } else{
//                    array[ai++] = array[ri++];
//                }
//        }

        // 会产生死循环
//        while (li < le) {
//            if (array[ri] > leftArray[li]) {
//                array[ai++] = leftArray[li++];
//
//            } else if (ri < re) {
//                array[ai++] = array[ri++];
//            }
//        }



    }
}
