package com.yc.Leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class _83_删除排序链表中的重复元素 {

    //递归
    public ListNode deleteDuplicate2(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicate2(head.next);
        if (head.val == head.next.val) head.next = head.next.next;
        return head;
    }


    //指针
    public ListNode deleteDuplicate1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }

        }
        return head;
    }

    //适用于非排序链表
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode newHead = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            }else {
                set.add(head.next.val);
                head = head.next;
            }

        }
        return newHead;
    }
}
