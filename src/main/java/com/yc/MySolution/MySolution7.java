package com.yc.MySolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 求某一年的多少天
 */
public class MySolution7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String date = in.next();
        String[] dates = date.split("-");
        int year = Integer.parseInt(dates[0]);
        String month = dates[1];
        int day = Integer.parseInt(dates[2]);
        Map<String,Integer> days = new HashMap<>();
        days.put("01",0);
        days.put("02",31);
        days.put("03",59);
        days.put("04",90);
        days.put("05",120);
        days.put("06",151);
        days.put("07",181);
        days.put("08",212);
        days.put("09",243);
        days.put("10",273);
        days.put("11",304);
        days.put("12",334);
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    //是闰年
                    if (month.equals("01") || month.equals("02")) {
                        day = days.get(dates[1]) + day;
                    } else {
                        day = days.get(dates[1]) + day + 1;
                    }

                } else {
                    //不是闰年
                    day = days.get(dates[1]) + day;
                }

            } else {
                //是闰年
                if (month.equals("01") || month.equals("02")) {
                    day = days.get(dates[1]) + day;
                } else {
                    day = days.get(dates[1]) + day + 1;
                }
            }
        } else {
            day = days.get(dates[1]) + day;
        }
        in.close();
        System.out.println(day);
    }
}
