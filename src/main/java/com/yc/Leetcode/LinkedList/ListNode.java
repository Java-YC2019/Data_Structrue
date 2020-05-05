package com.yc.Leetcode.LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = node1;
        node3.next = null;
        System.out.println(node1 == null);
    }
}
