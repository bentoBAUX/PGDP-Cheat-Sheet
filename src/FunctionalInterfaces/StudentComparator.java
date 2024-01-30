package FunctionalInterfaces;

import java.util.Arrays;

class Student{
    String name;
    int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class StudentComparator implements java.util.Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getAge(),s2.getAge());
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 22),
                new Student("Bob", 20),
                new Student("Charlie",25)
        };
        Arrays.sort(students,new StudentComparator());

        for(Student student: students){
            System.out.println("Name: "+student.getName() + ", Age: "+student.getAge());
        }
    }
}