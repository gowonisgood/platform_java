package MyValidator0703;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentRepository {
    private Map<String, Student> students = new HashMap<>();

    public Student save(Student student) {
        Set<String> violations = MyValidator.validate(student);
        if (!violations.isEmpty()) {
            System.out.println("Validation errors: " + violations);
            return Student.NullStudent;
        }
        return students.put(student.getId(), student);
    }
}