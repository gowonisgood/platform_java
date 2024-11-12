package Java_platform.CourseRegistration_033.edu.pnu.member;

public class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "교수명='" + name + '\'';
    }
}
