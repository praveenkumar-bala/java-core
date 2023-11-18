package org.pk.reflection.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReflectionMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Entity entity = new Entity(1,"id");

        Class<? extends Entity> clss = entity.getClass();

        Method[] methods = clss.getMethods();
        for (Method method:methods) {
            System.out.println("Method name => "+method.getName()+" & return type => "+method.getReturnType()
            + " & Access => "+method.getModifiers() + " & Arguments => "+
                    Arrays.stream(method.getParameters()).map(Parameter::getName).collect(Collectors.joining(",")));
        }

        Method[] declaredMethods = clss.getDeclaredMethods();
        for (Method method:declaredMethods) {
            System.out.println("DeclaredMethods name => "+method.getName()+" & return type => "+method.getReturnType()
                    + " & Access => "+method.getModifiers() + " & Arguments => "+
                    Arrays.stream(method.getParameters()).map(Parameter::getName).collect(Collectors.joining(",")));
        }


        /**
         * calling method with argument
         */
        Method setMethod = clss.getMethod("setVal", int.class);
        setMethod.invoke(entity, 20);

        /**
         * calling method without arguments
         */
        Method getMethod = clss.getMethod("getVal", null);
        System.out.println(getMethod.invoke(entity));

        /**
         * Accessing private method
         */
        Method calcMethod = clss.getDeclaredMethod("calc", null);
        calcMethod.setAccessible(true);
        calcMethod.invoke(entity);


    }
}
