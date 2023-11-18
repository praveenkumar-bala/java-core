package org.pk.methodhandles.ex1;

public class Student {

    private static  int numOfStudents;

    private String name;

    private String course;

    public Student(){
        numOfStudents++;
    }

    private String printStudetInfo(){
        return "Number of Students is "+getNumOfStudents();
    }

    public Student(String name, String course) {
        numOfStudents++;
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public static int getNumOfStudents() {
        return numOfStudents;
    }

    public static void setNumOfStudents(int numOfStudents) {
        Student.numOfStudents = numOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
