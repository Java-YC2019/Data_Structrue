package com.yc.Leetcode.Array;

/**
 * 对角元素相等的矩阵
 * @Author: yc
 * @Date: 2019/10/9 16:23
 * @Version 1.0
 */
public class _766_托普利茨矩阵 {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int i = row, j = 0; i < matrix.length - 1 && j < matrix[0].length - 1; i++, j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        for (int col = 0; col < matrix[0].length - 1; col++) {
            for (int i = 0, j = col; i < matrix.length - 1 && j < matrix[0].length - 1; i++, j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};

//        System.out.println(a[2][1]);
        System.out.println(isToeplitzMatrix(a));
    }
}
