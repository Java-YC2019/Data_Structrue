package com.yc.MySolution;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 请编写一个函数，完成可以按GBK字节数分割字符串的功能。
 * 要求中文不能拆分半个，这样会出现乱码）。
 * 实现效果如下:splitByBytes("中文版Java",5)，得到["中文","版Jav","a"]。
 *
 * @Author: yc
 * @Date: 2019/10/8 16:41
 * @Version 1.0
 */
public class MySolution4 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ArrayList<String> strings = splitByBytes("中文版Java", 5);
        System.out.println(strings);
    }

    /*
    请编写一个函数，完成可以按GBK字节数分割字符串的功能。
    要求中文不能拆分半个，这样会出现乱码）。实现效果如下:splitByBytes("中文版Java",5)，得到["中文","版Jav","a"]。
     */
    public static ArrayList<String> splitByBytes(String src, int bytes) throws UnsupportedEncodingException {
        ArrayList<String> strings = new ArrayList<>();
        String split = "";
        String str;
        str = src;
        /*
         * gbk字符里面，一个汉字占两个字节，字母占一个字节，汉字编码为负数，字母编码为正数
         * */
        while (str.length() > 0) {
            byte[] buf = str.getBytes("gbk");
            if (bytes >= buf.length) {
                split = str;
            } else {
                int count = 0;  // 计数器;
                for (int j = 0; j < bytes; j++) {
                    if (buf[j] < 0) {  // 中文两个字节，任何一个字节都是小于0;
                        // 判断在byte数组中截取位置之前有多少个编码小于0的字节；
                        // 若count为偶数，则说明此截取位置刚好为完整的中文字节;
                        // 若count为奇数，则说明当前位置为中文的一半，此截取位置之前为偶数，则完整的中文字节；
                        count++;
                    } else {    // 如果大于0，说明当前字节为非中文字节，则可以直接退出;
                        break;
                    }
                }
                if (count % 2 == 0) {
                    split = new String(buf, 0, bytes, "gbk");

                } else {
                    split = new String(buf, 0, bytes - 1, "gbk");

                }
            }
            strings.add(split);
            str = str.substring(split.length());

        }
        return strings;
    }

//    public static void splitString(String src, int bytes) throws UnsupportedEncodingException {
//
//        String str;
//        str = src;
//
//        // 首先将String转换成byte数组;
//        byte buf[] = str.getBytes("gbk");
//        @SuppressWarnings("unused")
//        String split = "";
//        // 若截取长度大于byte数组长度，则将字符串直接返回,特例O(∩_∩)O哈哈~
//        if (bytes >= buf.length) {
//            split = src;
//            System.out.println("截取" + bytes + "个字节为：" + split);
//        } else {
//            int count = 0;  // 计数器;
//            for (int j = 0; j < bytes; j++) {
//                if (buf[j] < 0) {  // 中文两个字节，任何一个字节都是小于0;
//                    // 判断在byte数组中截取位置之前有多少个编码小于0的字节；
//                    // 若count为偶数，则说明此截取位置刚好为完整的中文字节;
//                    // 若count为奇数，则说明当前位置为中文的一半，此截取位置之前为偶数，则完整的中文字节；
//                    count++;
//                } else {    // 如果大于0，说明当前字节为非中文字节，则可以直接退出;
//                    break;
//                }
//            }
//            if (count % 2 == 0) {
//                split = new String(buf, 0, bytes, "gbk");
//            } else {
//                split = new String(buf, 0, bytes - 1, "gbk");
//            }
//            System.out.println("截取" + bytes + "个字节为：" + split);
//
//        }
//        str = str.substring(split.length());
//        System.out.println(str);
//    }
}
