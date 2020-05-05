package com.yc.MySolution;

import java.util.*;

/**
 * 你有一条游轮，现在要从一个港口出发，环绕若干港口一周，在这一条环线上的每个
 * 港口各有一个加油站可以提供补给，第n个港口的加油站有柴油gas[n]，从第n个港口前
 * 往任意一个港口需要消耗柴油cost[n]。假设一开始游轮的油箱是空的，请问是否存在环
 * 绕所有港口一周的方案，不存在返回-1，存在返回其中的一组环绕的港口顺序（不能有重复）。
 */
public class MySolution1 {
    public static void main(String[] args) {
        int n = 20;
        int[] gas = new int[]{1,2,3,4,5,6,7,8,9};
        int[] cost = new int[]{2,3,5,6,6,6,8,8,1};
//        for (int i = 0; i < gas.length; i++) {
//            gas[i] = (int) (Math.random() * 100) + 1;
//            cost[i] = (int) (Math.random() * 100) + 1;
//        }
        System.out.println(Arrays.toString(gas));
        System.out.println(Arrays.toString(cost));
        List<Integer> list = solution(gas, cost);
        System.out.println(list);
    }

    //只要gas数组的总和大于等于cost，那么一定存在环绕一周的方案
    public static List<Integer> solution(int[] gas, int[] cost) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < gas.length; i++) {
            set.add(i);
            sum1 += gas[i];
            sum2 += cost[i];
        }
        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        List<Integer> list = new ArrayList<>();
        if (sum1 < sum2) {
            list.add(-1);
            return list;
        }
        int cur = 0;
        while (set.size() > 0) {
            for (int i = 0; i < gas.length; i++) {
                if (set.contains(i) && (gas[i] + cur) >= cost[i]) {
                    cur = gas[i] + cur - cost[i];
                    set.remove(i);
                    list.add(i);
                }
            }
        }
        return list;
    }
}
