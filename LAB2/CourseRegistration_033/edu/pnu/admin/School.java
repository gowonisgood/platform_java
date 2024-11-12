package Java_platform.CourseRegistration_033.edu.pnu.admin;

import Java_platform.CourseRegistration_033.edu.pnu.enroll.Lecture;
import Java_platform.CourseRegistration_033.edu.pnu.member.Student;

import java.util.ArrayList;
import java.util.List;

public class School {
    private final String name ;

    private List<Student> students = new ArrayList<>();
    private List<Lecture> lectures = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public void addStudentAll(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudentAll(){
        return students;
    }

    public Student findStudent(String studentName, int schoolYear) {
        Student target = new Student(studentName, schoolYear);
        for (int i=0; i < students.size(); i++){
            if (target.equals(students.get(i)))
                return students.get(i);
        }
        return null;
    }

    public Lecture findLecture(int lectureID) {
        for (Lecture c: lectures){
            if (c.getID() == lectureID)
                return c;
        }
        return null;
    }

    public void addLecture(Lecture newLecture) {
        lectures.add(newLecture);
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public void printLectureAll() {
        System.out.printf("\n --- 수강편람 화면 --- \n");
        for (Lecture c : lectures)
            System.out.println(c);
    }

    public void printStudentAll() {
        System.out.printf("\n --- 수강자 목록 화면 --- \n");
        for (Lecture c : lectures)
            System.out.printf("%s - %s\n", c.getCourseName(), c.getStudentAll());
    }

    public List<Lecture> getLectures() {
        return lectures;
    }
}