package org.pk.reflection.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionConstructor {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Entity> clss = Entity.class;
        Constructor<?>[] constructors = clss.getConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor.getName());
            System.out.println(constructor.getParameterCount());
        }

        Constructor<?>[] declaredConstructors = clss.getDeclaredConstructors();
        for (Constructor constructor: declaredConstructors){
            System.out.println(constructor.getName());
            System.out.println(constructor.getParameterCount());
        }

        Constructor<Entity> constructor = clss.getConstructor(int.class, String.class);
        Entity entity = constructor.newInstance(1,"StudentId");
        System.out.println(entity.toString());

        Constructor<Entity> declaredConstructor = clss.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Entity entity1 = declaredConstructor.newInstance();
        System.out.println(entity1.toString());

    }
}
