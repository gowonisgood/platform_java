package Java_platform.Genenric.OurSimpleRepository0603.repositories;

import Java_platform.Genenric.OurSimpleRepository0603.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository extends OurSimpleRepository<Professor> {
    // Implement your code
    public List<Professor> findByDepartment(String department) {
        List<Professor> foundProfessors = new ArrayList<>();

        for(Professor entity: entities){
            String entityDepartment = entity.getDepartment();
            if(entityDepartment.equals(department)){foundProfessors.add(entity);}
        }
        return foundProfessors;
    }
}
