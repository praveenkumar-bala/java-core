package org.pk.variableHandlesAPI.ex1;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class VariableHandleDemo {

    public static void main(String[] args) throws Throwable {

        Student student = new Student("Praveen", "Java");


        MethodHandles.Lookup lookup = MethodHandles.lookup();

        Class<?> aClass = lookup.findClass(Student.class.getName());

        MethodHandles.Lookup privateLookup = MethodHandles.privateLookupIn(aClass, lookup);

        VarHandle course = lookup.findVarHandle(aClass, "course", String.class);

        System.out.println(course.get(student));

        /**
         * Setting values to the variable
         */
        course.set(student, "Python");
        System.out.println(course.get(student));

        VarHandle name = privateLookup.findVarHandle(aClass, "name", String.class);

        System.out.println(name.get(student));


        /**
         * Static variable
         */

        VarHandle COLLEGE = privateLookup.findStaticVarHandle(aClass, "COLLEGE", String.class);

        System.out.println(COLLEGE.get());

        COLLEGE.set("BDU");
        System.out.println(COLLEGE.get());



    }
}
