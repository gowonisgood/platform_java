package Java_platform.Genenric.OurSimpleRepository0603.repositories;

import Java_platform.Genenric.OurSimpleRepository0603.models.Professor;
import Java_platform.Genenric.OurSimpleRepository0603.models.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends OurSimpleRepository<Student> {
    // Implement your code
    public List<Student> findByMajor(String major) {
        List<Student> foundStudents = new ArrayList<>();
        for(Student entity: entities){
            String entityMajor = entity.getMajor();
            if(entityMajor.equals(major)){foundStudents.add(entity);}
        }
        return foundStudents;
    }
}
