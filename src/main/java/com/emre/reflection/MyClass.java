package com.emre.reflection;

public class MyClass {

    private int num;
    private String name;

    public void test(){
        System.out.println("parameterless test() method");
    }
    public void testInt(int num){
        System.out.println("int parameter test() method with "+num);
    }
    public void testString(String temp){
        System.out.println("String parameter test() method with "+temp);
    }

}
