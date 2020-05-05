package com.yc.Leetcode.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @Author: yc
 * @Date: 2019/9/27 15:15
 * @Version 1.0
 */
class _225_用队列实现栈 {

}


class MyStack {
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.add(x);
        int count = queue.size();
        while (count-->1){
            queue.add(queue.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

}