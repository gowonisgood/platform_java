package Java_platform.CourseRegistration_033.edu.pnu.enroll;

public class Course {
    private static int COUNTER = 1;
    int courseId;
    String name;
    String type;

    public Course(String name, String type) {
        this.courseId = COUNTER++;
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "교과목번호='" + courseId + "', 교과목명='" + name + "', 구분='" + type + "'";
    }
}
