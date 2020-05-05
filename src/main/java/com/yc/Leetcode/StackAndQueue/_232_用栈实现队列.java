package com.yc.Leetcode.StackAndQueue;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @Author: yc
 * @Date: 2019/9/27 14:36
 * @Version 1.0
 */
class _232_用栈实现队列 {


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.pop();
    }
}

class MyQueue {
    //栈1做队头，栈2做队尾
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack2.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack1.empty()) {

            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }


    /**
     * Get the front element.
     */
    public int peek() {

        if (stack1.empty()) {

            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }
}