package com.opensource.dada.ds.stack;

import java.util.Stack;

public class MinMaxStack {
    public static void main(String[] args) {

    }

    private Stack<Integer[]> minMaxStack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public Integer peek() {
        return stack.peek();
    }

    public Integer pop() {
        minMaxStack.pop();
        return stack.pop();
    }

    public void push(Integer number) {
        Integer[] newMinMax = new Integer[]{number, number};//min, max
        if (!minMaxStack.isEmpty()) {
            Integer[] lastMinMax = minMaxStack.peek();
            newMinMax[0] = Math.min(lastMinMax[0], number);
            newMinMax[1] = Math.max(lastMinMax[1], number);
        }
        minMaxStack.push(newMinMax);
        stack.push(number);
    }
    public Integer getMin() {
        return minMaxStack.peek()[0];
    }
    public Integer getMax() {
        return minMaxStack.peek()[1];
    }
}
