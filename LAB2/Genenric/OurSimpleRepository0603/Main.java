package Java_platform.Genenric.OurSimpleRepository0603;
import Java_platform.Genenric.OurSimpleRepository0603.models.*;
import Java_platform.Genenric.OurSimpleRepository0603.repositories.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        StudentRepository studentRepository = new StudentRepository();
        ProfessorRepository professorRepository = new ProfessorRepository();

        Person person1 = new Person(1L, "Apple Kim");
        Person person2 = new Person(2L, "Banana Lee");
        personRepository.save(person1);
        personRepository.save(person2);

        Student student1 = new Student(3L, "Cherry Park", "Computer Science");
        Student student2 = new Student(4L, "Durian Jo", "Mathematics");
        studentRepository.save(student1);
        studentRepository.save(student2);

        Professor professor1 = new Professor(5L, "Figs Choi", "Physics");
        Professor professor2 = new Professor(6L, "Grapes Oh", "Mathematics");
        professorRepository.save(professor1);
        professorRepository.save(professor2);

        Person foundPerson = personRepository.findById(1L);
        if (foundPerson != null) {
            System.out.println("Found Person: " + foundPerson.getName());
        }

        List<Student> csStudents = studentRepository.findByMajor("Computer Science");
        System.out.println("Students in Computer Science:");
        for (Student student : csStudents) {
            System.out.println(student.getName());
        }

        List<Professor> mathProfessors = professorRepository.findByDepartment("Mathematics");
        System.out.println("Professors in Mathematics department:");
        for (Professor professor : mathProfessors) {
            System.out.println(professor.getName());
        }

        personRepository.deleteById(2L);
        System.out.println("After deleting person with ID 2:");
        List<Person> allPersons = personRepository.findAll();
        for (Person person : allPersons) {
            System.out.println(person.getName());
        }
    }
}
