package com.yc.Leetcode.StackAndQueue;

import java.util.Stack;

/**
 * 最小栈
 * @Author: yc
 * @Date: 2019/9/27 15:48
 * @Version 1.0
 */
public class _155_最小栈 {


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());


    }
}

class MinStack {
    private Stack<Integer> datastack;
    private Stack<Integer> minstack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        datastack = new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        datastack.push(x);
        min = Math.min(min, x);
        minstack.push(min);

    }

    public void pop() {
        datastack.pop();
        minstack.pop();
        min = minstack.isEmpty() ? Integer.MAX_VALUE : minstack.peek();
    }

    public int top() {
        return datastack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}