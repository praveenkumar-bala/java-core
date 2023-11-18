# Reflection API
Reflection api is used to extract the information of the class and its
components like Fields, Modifiers, Methods, Constructors..

This reflection api is used in
1. Build tools ( Eclipse, IntelliJ for code intelisense)
2. Used in Spring, Hibernate frameworks

## Why
1. One of the design pattern SOLID, is talking about Open for Modification and Closed for new changes, `Reflection API `helps java to open for modification.
2. Reading and Modifying At Runtime (We can read and modify the class at runtime or we can update the capabilities using reflection)


## What is Reflection
Reflection API helps to modify the java class at runtime by making use of introspection. we can using class meta data ( means description of classes
and object within JVM) like class, variables, constructor and method at the runtime to change the value.

- Java reflection is the process of analysing and modifying all the capabilities of a class at runtime
- it is in `java.lang.reflect` package

### java.lang.Class
- Backbone of reflection. it provides the way to find and load any class 
- 

