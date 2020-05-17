package com.yc.Leetcode.MJ_03.链表;

public class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
	 @Override
	public String toString() {
		return val + " -> " + next;
	}
}
