package com.springmvc.test;

public class Test {
    public static void main(String[] args)  {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        MyClass myClass3 = new MyClass();
        System.out.println("1i--"+myClass1.i);
        //System.out.println("j--"+myClass1.j);
        System.out.println("2i--"+myClass2.i);
       // System.out.println("j--"+myClass2.j);
        System.out.println("3i--"+myClass3.i);
        ///System.out.println("j--"+myClass3.j);
        myClass1.j=2;
       /// System.out.println("j--"+myClass1.j);
        MyClass myClass4 = new MyClass();
        System.out.println("4i--"+myClass4.i);
       // System.out.println("4j--"+myClass4.j);
    }
}
 
class MyClass {
    public final double i = Math.random();
    public static double j = Math.random();
}