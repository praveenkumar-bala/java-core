package org.pk.reflection.example;


import java.lang.reflect.Constructor;

class MyClass {
    private MyClass() {
        System.out.println("My class Object is created");
    }
}

public class ReflectionDemo {


    public static void main(String[] args) {
        try {
            /**
             * We cannot create MyClass Object because constructor is privator
             */

            //MyClass obj = new MyClass();

            Class<?> aClass = Class.forName("org.pk.reflection.example.MyClass");
            Constructor constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
