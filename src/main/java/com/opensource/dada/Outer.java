package com.opensource.dada;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Outer
{
    Outer()
    {
        System.out.print("out");
    }

    class Inner
    {
        Inner()
        {
            System.out.print("in");
        }
        public void go()
        {
            System.out.print("go_in");
        }
    }

    /*public static void main (String [] args)
    {
        *//*Outer obj = new Outer();
        obj.fun();*//*

        Test2 [][] obj = new Test2[3][];
        System.out.println(obj[2][0].toString());
    }*/
    public static void throwit()
    {
        throw new RuntimeException();
    }
    public static void main(String args[])
    {
        /*try
        {
            System.out.println("Hello world ");
            throwit();
            System.out.println("try block ");
        }
        finally
        {
            System.out.println("Finally");
        }*/

        /*FileOutputStream out = null;
        try
        {
            out = new FileOutputStream("output.out");
            out.write(125486);
        }
        catch(IOException io)
        {
            System.out.println("Error");
        }
        finally {
            out.close();
        }*/

        int result = 0;

        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRuE");
        Boolean b4 = new Boolean("false");

        if (b1 == b2)result = 1;
        if (b1.equals(b2))result = result + 10;
        if (b2 == b4)result = result + 100;
        if (b2.equals(b4))result = result + 1000;
        if (b2.equals(b3))result = result + 10000;
        System.out.println(result);

        List<String>  list = new ArrayList<>();
        list.add("DoSelect");
        list.add("InMobi");
        list.add("CampusHash");
        list.add("mKhoj");
        list.add("Microsoft");

        System.out.println("Original: " + list);

        Collections.rotate(list, -2);

        System.out.println("Rotated: " + list);

        Order(null);

    }

    public static void Order(String s)
    {
        System.out.println("String");
    }
    public static void Order(Object o)
    {
        System.out.println("Object");
    }

    /*private int [3] a1 [ ] ;
    static int [ ] a2 ;
    public [ ] int a3 ;
    private int a4 [3];
    public int a5 [ ];
    public final int [ ] a6;*/
    void fun()
    {
        (new Inner() {}).go();
    }
}
class Test2 { }
