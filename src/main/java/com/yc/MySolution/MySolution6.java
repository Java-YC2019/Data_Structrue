package com.yc.MySolution;

import java.util.Scanner;

/**
 * 质数分解
 */
public class MySolution6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = 2;
        System.out.print(n + "=");
        while(n != 1) {
            if(n % k == 0) {
                if (n == k) {
                    System.out.print(k);
                } else {
                    System.out.print(k + "*");
                }
                n = n / k;
            }
            else {
                k = k + 1;
            }
        }
        in.close();
    }
}
