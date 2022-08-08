package com.opensource.dada.ds.stack;

public class FindDeleteMiddleElement<T> {
    public static void main(String[] args) {

    }
    class Node<T> {
        Node next;
        Node prev;
        Node middle;
        T value;
    }

    private Node<T> top;
    private int count = 0;

    public void push(T value) {
        count++;
        if (top==null) {
            top = new Node<T>();
            top.value = value;
            top.middle = top;
        } else {
            Node<T> temp = new Node<T>();
            temp.value = value;
            temp.next = top;
            top.prev = temp;
            if (count%2!=0) {
                temp.middle = top.middle.prev;
            }
            top = temp;
        }
    }

    public T pop() {
        if (count == 0 || top == null) {
            return null;
        }
        Node<T> temp = top.next;
        top.next = null;
        temp.prev = null;
        if (count % 2 != 0) {
            temp.middle = top.middle.prev;
        }
        top = temp;
        count--;
        return temp.value;
    }
    public T getMiddle() {
        if (count==0 || top==null) {
            return null;
        }
        return (T) top.middle.value;
    }
    public T deleteMiddle() {
        if (count == 0 || top == null) {
            return null;
        }
        Node<T> temp = top.middle;
        Node<T> next = temp.next;
        Node<T> prev = temp.prev;
        if (next!=null) {
            next.prev = prev;
        }
        if (prev!=null) {
            prev.next = next;
        }
        if (count % 2 != 0) {
            top.middle = prev;
        } else {
            top.middle = next;
        }

        count--;
        return temp.value;
    }
}
