package com.yc.Leetcode.LinkedList;

/**
 * 反转一个单链表
 *
 * @Author: yc
 * @Date: 2019/10/16 14:27
 * @Version 1.0
 */
public class _206_反转链表 {


    //递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next ==null) return head;

        ListNode newHead =reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //迭代--头插法2
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
    //迭代--头插法1
    public ListNode reverseList34(ListNode head) {
        if (head == null || head.next ==null) return head;

        ListNode next = head.next;
//        ListNode next = temp.next;
        head.next = null;

        while (next != null) {
            ListNode temp = next.next;
            next.next=head;
            head=next;
            next=temp;
        }
        return head;


    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next ==null) return head;

        ListNode temp = head.next;
        ListNode next = temp.next;
        head.next = null;

        while (temp != null) {
            temp.next = head;
            head = temp;
            temp = next;
            if (temp != null)
                next = temp.next;
        }
        return head;

    }

    public ListNode reverseList(ListNode head) {
        ListNode first = head;
        int length = 0;
        while (first != null) {
            first = first.next;
            length++;
        }
        int count = length / 2;//需要交换的次数
        first = head;
        ListNode res = null;
        ListNode temp = head;
        for (int i = 0; i < count; i++) {
            ListNode node = findNode(temp, length - 1);
            ListNode listNode = exchangeNode(head, node);
            if (i == 0) res = listNode;
            head = head.next;
            length--;
            temp = first;
        }
        return res;
    }

    //要交换的节点（距离第一个节点的距离为length）
    public ListNode findNode(ListNode node, int length) {
        for (int i = 0; i < length; i++) {
            node = node.next;
        }
        return node;
    }

    public ListNode exchangeNode(ListNode preNode, ListNode sufNode) {
        int temp1 = preNode.val;
        int temp2 = sufNode.val;
        preNode.val = temp2;
        sufNode.val = temp1;
        return preNode;
    }
}
