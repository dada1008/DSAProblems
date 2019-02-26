package com.opensource.dada;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        B a = new B();
        a.print();
        a.callMe();

    }
}

class A {
    public void print() {
        System.out.println("Print A");
    }
}

class B extends A {
    public void print() {
        System.out.println("Print B");
    }

    public void callMe() {
        System.out.println("callMe B");
    }
}
