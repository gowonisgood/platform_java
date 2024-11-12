package MyComparableInterface0801;

import java.util.Comparator;

public class Student implements MyComparable,Comparable<Student>{
    private Long studentID;
    private String name;
    private double grade;
    public Student(Long studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public Long getStudentID(){
        return studentID;
    }

    public double getGrade(){
        return grade;
    }

    public boolean isHigherRanked(Student student) {
        return this.grade > student.getGrade();
    }

    public int compareTo(Student student) {
        return this.studentID.compareTo(student.getStudentID());
    }

    public static Comparator<Student> nameComparator =
        new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        };


    public static Comparator<Student> gradeComparator =
        new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return (int)(s2.getGrade() - s1.getGrade());
            };
        };

    @Override
    public String toString() {
        return String.format("Student{id=%d,name='%s',grade=%.1f}", studentID, name, grade);
    }

}
