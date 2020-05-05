package com.yc.Leetcode.pointer;

public class _633_平方数之和 {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(5));
        System.out.println(Math.sqrt(7));
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(8));
    }
    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        int l = 0;
        int r = sqrt;
        while (l <= r) {
            int cur = l * l + r * r;
            if (cur == c) return true;
            else if (cur > c) r--;
            else l++;
        }
        return false;
    }
}
