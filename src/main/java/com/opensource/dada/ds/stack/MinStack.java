package com.opensource.dada.ds.stack;

public class MinStack {

    public static void main(String[] args) {

    }

    /** initialize your data structure here. */
    public Elem top;

    public MinStack() {

    }

    public void push(int x) {
        if(top == null){
            top = new Elem(x, x);
        }else{
            Elem e = new Elem(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }
    }

    public void pop() {
        if(top == null)
            return;
        Elem temp = top.next;
        top.next = null;
        top = temp;
    }

    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }

    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }
}

class Elem{
    public int value;
    public int min;
    public Elem next;

    public Elem(int value, int min){
        this.value = value;
        this.min = min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
