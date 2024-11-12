package Java_platform.Genenric.OurSimpleRepository0603.models;
import java.util.List;
import java.util.ArrayList;
public class Professor extends Person {
    private String department;

    public Professor(Long id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
