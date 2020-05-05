package com.yc.Leetcode.LinkedList;

public class _24_两两交换链表中的节点 {

    //递归实现
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }



    //迭代
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
//        ListNode next = head.next;
//        head.next = head.next.next;
//        next.next = head;
//        ListNode cur = next.next;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode newHead = pre;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next;
            pre.next = pre.next.next;
            temp.next = temp.next.next;
            pre.next.next = temp;
            pre = pre.next.next;
        }
        return newHead.next;
    }
}
