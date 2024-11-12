package Java_platform.CourseRegistration_033.edu.pnu.enroll;
import Java_platform.CourseRegistration_033.edu.pnu.member.Student;
import java.util.ArrayList;
import java.util.List;
public class Enrollment {
    private boolean available;
    private List<Lecture> enrolledLectures;

    private static final Enrollment instance = new Enrollment();

    private Enrollment(){
        enrolledLectures = new ArrayList<>();
    }

    public static Enrollment getInstance(){
        return instance;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

    public void enroll(Lecture lecture, Student student){
        if(isAvailable()){
            if (lecture.isEnrollment()) {
                if (!lecture.isRegistration(student)) {
                    lecture.addStudent(student);
                    enrolledLectures.add(lecture);
                    System.out.println(student.getName() + " 학생이 " + lecture.getCourseName() + " 강의에 성공적으로 수강신청 하였습니다.");
                } else {
                    System.out.println(student.getName() + " 학생은 이미 " + lecture.getCourseName() + " 강의를 등록하였습니다.");
                }
            } else {
                System.out.println("강의에 남은 자리가 없습니다.");
            }
        } else{
            System.out.println("수강신청 기간이 아닙니다.");
        }

    }

    public void drop(Lecture lecture, Student student){
        if(isAvailable()) {
            if (lecture.isRegistration(student)) {
                lecture.removeStudent(student);
                enrolledLectures.remove(lecture);
                System.out.println(student.getName() + " 학생이 " + lecture.getCourseName() + " 강의를 취소하였습니다.");
            } else {
                System.out.println(student.getName()+"학생이 등록되지 않았습니다.");
            }
        }else{
            System.out.println("수강신청 기간이 아닙니다.");
        }
    }

}
