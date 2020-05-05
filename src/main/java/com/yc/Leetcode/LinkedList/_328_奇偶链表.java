package com.yc.Leetcode.LinkedList;

public class _328_奇偶链表 {
    /**
     * 先将奇数链表串起来，再将偶数链表串起来。再把奇数链表连到偶数链表
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head,evenHead = head.next,even = evenHead;
        while (odd != null && odd.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
