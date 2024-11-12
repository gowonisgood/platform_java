package Java_platform.CourseRegistration_033.edu.pnu.enroll;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import Java_platform.CourseRegistration_033.edu.pnu.member.Student;

public class WishListService {
    private boolean available;
    private Map<Lecture, List<Student>> wishClasses;

    private static final WishListService instance = new WishListService();

    private WishListService() {
        wishClasses = new HashMap<>();
    }

    public static WishListService getInstance() {
        return instance;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void enroll(Lecture lecture, Student student) {
        if(isAvailable()){
            wishClasses.putIfAbsent(lecture, new ArrayList<>());
            wishClasses.get(lecture).add(student);
            System.out.println("학생: "+ student.getName()+" 이(가) "+ lecture.getCourseName()+" 희망과목 리스트에 추가되었습니다.");
        } else {
            System.out.println("희망과목담기 기간이 아닙니다.");
        }
    }

    public void enrollAll(){
        for(Map.Entry<Lecture, List<Student>> entry : wishClasses.entrySet()){
            Lecture lecture = entry.getKey();
            List<Student> students = entry.getValue();

            for(Student student : students){
                if(lecture.isEnrollment()){
                    lecture.addStudent(student);
                    //System.out.println("학생: "+student.getName()+" 이(가)"+lecture.getCourseName()+" 자동신청 되었습니다.");
                } else{
                    //System.out.println("강의 "+ lecture.getCourseName()+" 은(는) 정원이 다 찼습니다.");
                }
            }
        }

        wishClasses.clear();
    }

}
