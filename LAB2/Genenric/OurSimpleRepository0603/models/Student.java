package Java_platform.Genenric.OurSimpleRepository0603.models;
import java.util.List;
import java.util.ArrayList;
public class Student extends Person {
    private String major;

    public Student(Long id, String name, String major) {
        super(id, name);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
