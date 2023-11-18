# Method Handles API in Java
1. Introduced Java 1.7
2. Method handle is an alternative of Java Reflection API

Method handles are low level mechanism for finding, adapting and invoking methods.  The method objects handles are immutable and do not have a display state.

To create and use, MethodHandle you need to perform 4 steps:

1. Create search descriptor - lookup 
2. Declare method type 
3. Search for method handle 
4. Call method handle

## Method Handles vs Reflection
Both are created for different purposes and differ in characterstics.

From a performance point of view, the MethodHandles API can be much faster than the Reflection API, since access checks are performed at the time of creation rather than execution . In the presence of a security manager, this difference increases, because searching for classes and getting their items are subject to additional checks.


## 1. Making a Lookup
A factory object responsible for creating method handles for methods, constructors, and fields visible to the lookup class.

Using the MethodHandles API, you can create a lookup object with different access modes.

Create a lookup that provides access to public methods:

```java 
    MethodHandles.Lookup publicLookup = MethodHandles.publicLookup();
```

 if we need access to the public and protected methods, we can instead use the lookup () method:

```java
    MethodHandles.Lookup lookup = MethodHandles.lookup();
```

if you want to access private methods, the use 