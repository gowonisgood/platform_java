package MyComparableInterface0801;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(202355001L, "Kim", 85.5));
        students.add(new Student(202355002L, "Lee", 92.0));
        students.add(new Student(202355003L, "Park", 78.0));

        System.out.println("Sorted by ID:");
        Collections.sort(students);
        printStudents(students);

        System.out.println("\nSorted by Name:");
        Collections.sort(students, Student.nameComparator);
        printStudents(students);

        System.out.println("\nSorted by Grade (Descending):");
        Collections.sort(students, Student.gradeComparator);
        printStudents(students);

        System.out.println("\nComparing ranks:");
        Student s1 = students.get(0);
        Student s2 = students.get(2);
        System.out.println("Is " + s1.getName() + " higher ranked than " + s2.getName() + "? " + s1.isHigherRanked(s2));
    }

    private static void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}