package com.emre.reflection;

import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("com.emre.reflection.MyClass");
            for (Method method : cls.getDeclaredMethods()) {
                System.out.println("Method name = "+method.getName() +"\nReturn Type = "
                        + method.getReturnType() + "\nParameter Count = "+method.getParameterCount());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
