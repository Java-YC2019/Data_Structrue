package com.yc.Leetcode.LinkedList;

public class _21_合并两个有序链表 {
    //将短表插入到长表
    //从两条链表头节点开始取值新建链表。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode Node = new ListNode(-1);
        ListNode newHead = Node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                Node.next = l1;
                    l1 = l1.next;

            } else {
                Node.next = l2;
                    l2 = l2.next;

            }
            Node = Node.next;

        }
        Node.next = l1 != null ? l1 : l2;
        return newHead.next;
    }
    public void Insert(ListNode Node, ListNode l) {
        Node.next = l;
        l = l.next;
        Node = Node.next;
    }
}
