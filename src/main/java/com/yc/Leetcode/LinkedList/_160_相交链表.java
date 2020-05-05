package com.yc.Leetcode.LinkedList;

/**
 * 两个链表的交点
 *
 * @Author: yc
 * @Date: 2019/9/26 9:51
 * @Version 1.0
 */
public class _160_相交链表 {

    //当满足A.next = B.next 时该节点为相交节点。为了使AB同步，AB同时遍历。当遍历到尾节点时。从另外一个链表的头节点开始遍历
    //第二轮到相交节点时，两边是同步的。

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode firstA = headA;
        ListNode firstB = headB;


        while (headA != headB) {


            headA = headA != null ? headA.next : firstB;

            headB = headB != null ? headB.next : firstA;

        }


        return headA;
    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode firstA = headA;
        ListNode firstB = headB;

        if (firstA == null || firstB ==null) return null;
        while (headA != headB) {
            ListNode lastA = null;
            ListNode lastB = null;
            if (headA.next ==null) {
                 lastA = headA;
            }
            if (headB.next ==null) {
                lastB = headB;
            }
            if (lastB != lastA && lastA != null && lastB != null) return  null;

            headA = headA.next != null ? headA.next : firstB;

            headB = headB.next != null ? headB.next : firstA;


        }
        //A B
        //3 2
        //2 3
        //

        return headA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int index = 0, indexA = 0, indexB = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (A != null) {
            indexA++;
            A = A.next;
        }
        while (B != null) {
            indexB++;
            B = B.next;
        }
        if (indexA > indexB) {
            index = indexA - indexB;
            while (index != 0) {
                headA = headA.next;
                index--;
            }
        } else {
            index = indexB - indexA;
            while (index != 0) {
                headB = headB.next;
                index--;
            }
        }
        while (headA != headB && headA != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


}
