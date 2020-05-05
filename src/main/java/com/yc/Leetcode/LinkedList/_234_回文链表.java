package com.yc.Leetcode.LinkedList;

public class _234_回文链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(isPalindrome2(node1));


    }
    //直接遍历时反转前半段链表,实际上的操作数是一样的，都是遍历一遍，然后反转半条链表，再比对

    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head, l1 = null, l2 = null;

        while (fast.next != null && fast.next.next != null) {
            //当链表长度为奇数时，fast走到最后一个，slow刚好为中间一个。
            //当链表长度为偶数时，fast走到倒数第二个，slow刚好为前半个链表的最后一个节点。

            //反转链表
            //l1指向slow前一个
            ListNode temp = slow;
            fast = fast.next.next;
            slow = slow.next;
            temp.next = l1;
            l1 = temp;
        }

        l2 = slow.next;
        if (fast.next != null) {//链表长度为偶数，l1向后再移一位。
            slow.next = l1;
            l1 = slow;
        }
        //比较
        while (l2 !=null) {
            if (l2.val != l1.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    //可以找到链表的中点，然后将链表的后半部分反转比较
    //关键在于怎么找到中点，可以遍历第一遍记录节点总数，再从头找 复杂的为2n
    //还可以用快慢指针，复杂度为n
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            //当链表长度为奇数时，fast走到最后一个，slow刚好为中间一个。
            //当链表长度为偶数时，fast走到倒数第二个，slow刚好为前半个链表的最后一个节点。

            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        //使用头插法反转后半链表

        ListNode next = newHead.next;

        newHead.next = null;

        while (next != null) {
            ListNode temp = next;
            next = next.next;
            temp.next = newHead;
            newHead = temp;
        }

        //比较
        while (newHead != null) {
            if (newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }


}
