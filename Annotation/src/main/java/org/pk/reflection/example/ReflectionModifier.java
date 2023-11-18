package org.pk.reflection.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionModifier {

    public static void main(String[] args) throws NoSuchMethodException {
        Entity e = new Entity(10, "id");
        Class<? extends Entity> aClass = e.getClass();
        if(Modifier.isPublic(aClass.getModifiers())) {
            System.out.println(aClass.getModifiers());
            System.out.println(Modifier.toString(aClass.getModifiers()));
        }

        Method method = aClass.getDeclaredMethod("calc");
        System.out.println(Modifier.toString(method.getModifiers()));



    }
}
