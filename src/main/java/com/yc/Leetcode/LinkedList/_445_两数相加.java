package com.yc.Leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class _445_两数相加 {

    //要注意到当链表相加位数增大时，链表的长度需要加1


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode first1 = l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode first2 = l2;

        String s1 = "";
        String s2 = "";

        while (l1 != null) {
            s1 += l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            s2 += l2.val;
            l2 = l2.next;
        }
        int i1 = 0;
        int i2 = 0;
        int interval = Math.abs(s1.length() - s2.length());
        if (s1.length() >= s2.length()) {
            String substr1 = s1.substring(interval);
            i1 = Integer.parseInt(substr1);
            i2 = Integer.parseInt(s2);
            int num = i1 + i2;
            while (interval-- > 0) {
                first1 = first1.next;
            }
            int i = 0;
            while (first1 != null) {
                first1.val = Integer.parseInt(String.valueOf(String.valueOf(num).charAt(i++)));
                first1 = first1.next;
            }
            return head1;
        } else {
            String substr2 = s2.substring(s2.length() - s1.length());
            i1 = Integer.parseInt(s1);
            i2 = Integer.parseInt(substr2);
            int num = i1 + i2;
            while (interval-- > 0) {
                first2 = first2.next;
            }
            int i = 0;
            while (first2 != null) {
                first2.val = Integer.parseInt(String.valueOf(String.valueOf(num).charAt(i++)));
                first2 = first2.next;
            }
            return head2;
        }


    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first1 = l1;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode first2 = l2;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        int lh1 = list1.size();
        int lh2 = list2.size();
        int interval = Math.abs(lh1 - lh2);
        int int1 = 0;
        int int2 = 0;
        if (lh1 <= lh2) {
            for (int i = lh1 - 1; i >= 0; i--) {
                int1 += list1.get(i) * (int)Math.pow(10,lh1 - 1 - i);
                int2 += list2.get(i + interval) * (int)Math.pow(10,lh1 - 1 - i);
            }
            int num1 = int1 + int2;
            for (int i = lh1 - 1; i >= 0; i--) {
                int temp = num1 % 10;
                list1.add(i, temp);
                num1 = (num1 - temp) / 10;
            }
            int i = 0;
            while (first2 != null) {
                while (interval-- > 0) {
                    first2 = first2.next;
                }
                first2.val = list1.get(i++);
                first2 = first2.next;
            }
            return head2;
        }else {
            for (int i = lh2 - 1; i >= 0; i--) {
                int1 += list1.get(i + interval) * (int)Math.pow(10,lh2 - 1 - i);
                int2 += list2.get(i) * (int)Math.pow(10, lh2 - 1 - i);
            }
            int num2 = int1 + int2;
            for (int i = lh2 - 1; i >= 0; i--) {
                int temp = num2 % 10;
                list2.add(i, temp);
                num2 = (num2 - temp) / 10;
            }
            int i = 0;
            while (first1 != null) {
                while (interval-- > 0) {
                    first1 = first1.next;
                }
                first1.val = list2.get(i++);
                first1 = first1.next;
            }
            return head1;
        }
    }

}
