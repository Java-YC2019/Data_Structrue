package com.yc.DataStructrue.sort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{20, 5, 8, 3, 3, 3, 3, 3, 15, 8, 96, 74, 1, 6, 47};
        SortUtils.MergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
