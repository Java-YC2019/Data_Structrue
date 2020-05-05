package com.yc.Leetcode.LinkedList;

public class _19_删除链表的倒数第N个节点 {
    //当一个节点往后遍历n次之后等于null，则这个就是要删除的节点，从头节点开始遍历n次，如果没到null，
    // 再从头节点增加一个指针，同时往后遍历。到第一个指针遍历到尾节点时。第二个节点为要删除节点的前驱节点。


    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast ==null) return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode newHead = head;

        while (n > 0) {
            head = head.next;
            n--;
        }
        if (head != null) {
            int count = 0;
            while (head != null) {
                head = head.next;
                count++;
            }
            ListNode temp = newHead;
            while (count > 1) {
                temp = temp.next;
                count--;
            }
            temp.next = temp.next.next;
        } else {
            newHead.next = newHead.next.next;
        }
        return newHead;
    }

//    public ListNode removeNthFromEnd2(ListNode head, int n) { //参考代码
//        ListNode fast = head;
//        while (n-- > 0) {
//            fast = fast.next;
//        }
//        if (fast == null) return head.next;
//        ListNode slow = head;
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return head;
//    }
}
