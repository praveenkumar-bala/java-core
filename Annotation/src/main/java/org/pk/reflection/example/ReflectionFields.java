package org.pk.reflection.example;

import java.lang.reflect.Field;

public class ReflectionFields {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Entity e = new Entity(10 , "id");
        Class<? extends Entity> clss = e.getClass();
        /**
         * This will return based access modifier (private is not returned)
         */
        Field[] clssFields = clss.getFields();
        for (Field field: clssFields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

        /**
         * Return all the fields 
         */
        Field[] declaredFields = clss.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println("Name "+field.getName()+" & Type "+field.getType());
        }

        Field type = clss.getField("type");
        type.set(e, "Roll Number");

        Field id = clss.getDeclaredField("val");
        // id is an private field
        id.setAccessible(true);
        id.set(e, 121);

        System.out.println(e.toString());

    }
}
