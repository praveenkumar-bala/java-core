package org.pk.methodhandles.ex1;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class MethodHandleDemo {

    public static void main(String[] args) throws Throwable {


        /**
         * Lookup methods
         */

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Class<?> aClass = lookup.findClass(Student.class.getName());

        System.out.println(aClass.getName());

        /**
         * Invoke the constructor
         */

        MethodType defaultCons = MethodType.methodType(void.class);
        MethodHandle defaultConsHandle = lookup.findConstructor(aClass, defaultCons);
        Student s1 = (Student) defaultConsHandle.invoke();

        System.out.println(s1.toString());

        MethodType paramCons = MethodType.methodType(void.class, String.class, String.class);
        MethodHandle paramsConsHandle = lookup.findConstructor(aClass, paramCons);
        Student s2 = (Student) paramsConsHandle.invoke("Praveen", "Java");
        System.out.println(s2.toString());

        /**
         * Invoking getter method
         */
        MethodType methodType = MethodType.methodType(String.class);
        MethodHandle getCourse = lookup.findVirtual(aClass, "getCourse", methodType);
        System.out.println(getCourse.invoke(s2));


/**
 * Example of private lookup with findGetter
 */
        MethodHandles.Lookup privateLookup = MethodHandles.privateLookupIn(aClass, lookup);
        MethodHandle nameGetterHandle = privateLookup.findGetter(aClass, "name", String.class);
        System.out.println(nameGetterHandle.invoke(s2));
/**
 * Invoking setter method
 */

        MethodType setCourseMethodType = MethodType.methodType(void.class, String.class);
        MethodHandle setCourse = lookup.findVirtual(aClass, "setCourse", setCourseMethodType);
        setCourse.invoke(s1, "Python");

        /**
         * Example of private lookup with findSetter
         */

        MethodHandle nameSetterHandle = privateLookup.findSetter(aClass, "name", String.class);
        nameSetterHandle.invoke(s1, "Kannan");

        System.out.println(s1);

        /**
         * Method Handle for static Methods
         */

        MethodType methodType1 = MethodType.methodType(int.class);
        MethodHandle getNumOfStudents = lookup.findStatic(aClass, "getNumOfStudents", methodType1);
        System.out.println(getNumOfStudents.invoke());

        MethodType methodType2 = MethodType.methodType(void.class, int.class);
        MethodHandle setNumOfStudents = lookup.findStatic(aClass, "setNumOfStudents", methodType2);
        setNumOfStudents.invoke(10);

        System.out.println(getNumOfStudents.invoke());

        /**
         * Access private methods
         */

        MethodType methodType3 = MethodType.methodType(String.class);
        MethodHandle printStudetInfo = privateLookup.findVirtual(aClass, "printStudetInfo", methodType3);
        System.out.println(printStudetInfo.invoke(s1));

        /**
         * Using reflection api to access private method
         */
        Method printStudetInfo1 = Student.class.getDeclaredMethod("printStudetInfo");
        /**
         * Private lookup
         */
        MethodHandle unreflect1 = privateLookup.unreflect(printStudetInfo1);
        System.out.println(unreflect1.invoke(s2));
/**
 * lookup
 */
        printStudetInfo1.setAccessible(true);
        MethodHandle unreflect = lookup.unreflect(printStudetInfo1);
        System.out.println(unreflect.invoke(s2));


    }


}
