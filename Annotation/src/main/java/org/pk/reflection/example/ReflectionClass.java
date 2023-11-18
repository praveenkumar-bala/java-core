package org.pk.reflection.example;

class MyClass1 {
    public MyClass1() {
        System.out.printf("MyClass object initiated");
    }
}

public class ReflectionClass {


    /**
     * Below are the possible ways of getting class metadata
     */
    public static void main(String[] args) {


        try {

            /**
             * Option 1- Class.forname("full path of the class") is used to load the class
             */
            Class<?> clss1 = Class.forName("org.pk.reflection.example.MyClass1");

            /**
             * Option 2 : ClassName.class
             */
            Class<?> clss2 = MyClass1.class;

            /**
             * Option 3 : object.getClass()
             */
            MyClass1 myClass1 = new MyClass1();
            Class<?> clss3 = myClass1.getClass();


            /**
             * Example way of getting metadata of an class
             */

            //Return the super class meta data
            Class<?> clss1Superclass = clss1.getSuperclass();

            //Interfaces
            Class<?>[] interfaces = clss1.getInterfaces();




        } catch (Exception e) {

        }
    }
}
