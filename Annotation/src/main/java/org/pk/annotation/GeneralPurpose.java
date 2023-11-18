package org.pk.annotation;

import java.util.ArrayList;

class Parent{
    public void m1(){
        System.out.println(" M1 Parent Implementation");
    }
    @Deprecated
    public void m2(){
        System.out.println(" M2 Parent Implementation ");
    }
}
public class GeneralPurpose extends Parent{

    @Override
    public void m1(){
        System.out.println("M1 Child Implementation");
    }

    public static void main(String[] args) {
        @SuppressWarnings(value = {"unused"})
        int a = 10;

        @SuppressWarnings("unused")
        int b = 10;

        @SuppressWarnings({"rawtypes", "unsued"})
//        @SuppressWarnings("all")
        ArrayList list = new ArrayList();



    }
}
