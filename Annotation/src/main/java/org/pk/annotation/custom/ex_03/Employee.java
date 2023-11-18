package org.pk.annotation.custom.ex_03;

/**
 * When you define annotation multiple times you will get an error.
 * We can use @Repeatable annotation to allow them
 */
@Designation("Manager")
@Designation("Developer")
public class Employee {
}
