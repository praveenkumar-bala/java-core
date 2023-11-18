# Java Reflection and Annotations

1. Eclipse and IntelliJ using reflection to provide intellisense
2. Spring and Hibernate using annotations and reflection

Open closed principle - means open for extension and closed for modification.
We can use `@Annotation - to extend the capabiity`


## What
- Annotations are used to define metadata or supplement information about program.
- Introduced in java 5
- Can be used with class, method, variables, etc.,

### Example
`@Override` - we can use this annotation to override methods in super class. however we can override the method without 
using these annotations. but the problem is we can accidentally change the method signature without compile time error.
If you use this annotation then you will get compile time error.

So Annotation are just more than just defining metadata, but they can change the way of compilation.

## Declaration
```
[access specifier] @interface <Annotation Name> {
    <Data Type> <Member Name> () [default value];
}
```
## Utilization
```
    @<Annotation Name> (member = value)
```
## Variants of Annotations

### 1. Marker Annotations
The only purpose is to mark a declaration. These annotations contain no members and do not consist of any data.
`@Override` is an example

## 2. Single Value Annotations
Contains only one member and allow a shorthand form of specifying the value of member.
<br/><br/>
Example
- @SuppressWarnings(value="Unchecked")
- @SuppressWarnings("Unchecked")

## 3. Multi Value Annotations
Accept more than one member

# Types Of Annotations
There are two types annotations in java
1. Standard Annotations
2. Meta Annotations

# Standard in Annotations
Standard annotations are java inbuilt annotations. There are two types
## 1. General Purpose Annotations
- Commonly used by us
- It is in `java.lang` packages. '
- Some of the annotations are
```java
    @Deprecated
    @Override
    @SuppressWarnings("Unchecked")
    @FunctionalInterface
```
## 2. Meta Annotations
- Meta Annotations are used to define the metadata to the annotations. It is used heavily at the time of
annotation creation.
- It is in `java.lang.annotation` package
- Some of the annotations are

```java
    import java.lang.annotation.*;
    @Documented //The use of @Documented annotation in the code enables tools like Javadoc to process it and include the annotation type information in the generated document.
    @Inherited // Used to inherit the parent annotation to the child class, by default annotation will not inherit.
    @Target(ElementType.METHOD) //Describes the targets to which an annotation can be applied.
    @Retention(RetentionPolicy.RUNTIME) // Describes how long the annotation should be retained by the compiler
    @Repeatable() // Denotes that an annotation can be applied multiple times in the same context; i.e. a class can have the same annotation applied to it two or more times

```


# @Documented
When you generate a java doc using `javadoc absolute_file_path`, Usually `javadoc` will not generate the document about the annotations.
but when the annotation marked with @Documented then javadoc will use that information to build the documentations.

# @Retention(RetentionPolicy.RUNTIME)
We specify the life span of particular annotation using this retention meta annotations.
Possible values
1. Source - Used still compilation after compilation it will get discorded by the compiler
2. Class - Annotations are to be recorded in the class file by the compiler but need not be retained by the VM at run time. This is the default behavior.
3. Runtime - Annotations are to be recorded in the class file by the compiler and retained by the VM at run time, so they may be read reflectively.
