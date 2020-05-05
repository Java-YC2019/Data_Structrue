package com.yc.MySolution;

import java.util.Scanner;

/**
 * 斜角打印
 */
public class MySolution5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int temp = 0;
        int value = 1;
        for(int i = a; i >= 1; i--) {
            int temp2 = temp + 2;
            int val = value;
            for(int j = i; j >= 1; j--) {
                if(j == i)System.out.print(value + "\t");
                else{
                    value = value + temp2;
                    System.out.print(value + "\t");
                    temp2++;
                }
            }
            temp++;
            value = val;
            value = value + temp;
            System.out.println();
        }
        in.close();
    }

}
