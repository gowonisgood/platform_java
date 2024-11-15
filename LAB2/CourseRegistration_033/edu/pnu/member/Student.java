package Java_platform.CourseRegistration_033.edu.pnu.member;

import java.util.Objects;

public class Student  {
    private String name ;
    private int year ;

    public Student(String studentName, int schoolYear) {
        this.name = studentName;
        this.year = schoolYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

    @Override
    public String toString() {
        return "[" +
                name + ", " +
                year + "학년" +
                "]";
    }

    public String getName() {
        return name;
    }
}
