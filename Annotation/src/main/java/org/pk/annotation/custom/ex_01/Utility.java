package org.pk.annotation.custom.ex_01;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MostUsed
@MostUsedInherited
public class Utility {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        /**
         * @MostUsed
         * @MostUsedInherited
         */
        Class<Utility> utilityClass = Utility.class;
        Annotation[] declaredAnnotations = utilityClass.getAnnotations();
        for (Annotation annotation : declaredAnnotations
        ) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            System.out.println(aClass.getName());
        }

        /**
         * @MostUsedInherited because it is using @Inherited Annotations
         */
        Class<SubUtility> subUtilityClass = SubUtility.class;
        Annotation[] declaredAnnotations1 = subUtilityClass.getAnnotations();
        for (Annotation annotation : declaredAnnotations1
        ) {

            Class<? extends Annotation> aClass = annotation.annotationType();
            System.out.println(aClass.getName());
        }

        /**
         * Reading Annotations
         */

        Constructor<Utility> utilityClassConstructor = utilityClass.getConstructor();
        Utility utility = utilityClassConstructor.newInstance();
        Method[] declaredMethods = utilityClass.getDeclaredMethods();
        for (Method method : declaredMethods
        ) {
            if(method.isAnnotationPresent(MostUsed.class)){
                method.invoke(utility, "Go Lang");
                /**
                 * Using default value
                 */
                MostUsed annotation = method.getAnnotation(MostUsed.class);
                method.invoke(utility, annotation.value());
            }
        }
    }

    void doStuff() {
        System.out.println("Doing some stuff");
    }

    @MostUsed("Python")
    void doStuff(String args) {
        System.out.println(" Operating on : " + args);
    }

    void doStuff(int i) {
        System.out.println(" Operating on : " + i);
    }
}

class SubUtility extends Utility {

}


