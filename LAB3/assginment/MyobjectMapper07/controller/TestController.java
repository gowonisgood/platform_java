package controller;

import annotation.RequestJsonBody;
import model.Person;
import model.Student;

public class TestController {
    public void savePerson(@RequestJsonBody Person person) {
        //System.out.println("Saved Person object:");
        System.out.println("Parsed Person object:");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }

    public void saveStudent(@RequestJsonBody Student student) {
        //System.out.println("Saved Student object:");
        System.out.println("Parsed Student object:");
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("GPA: " + student.getGpa());
    }
}

