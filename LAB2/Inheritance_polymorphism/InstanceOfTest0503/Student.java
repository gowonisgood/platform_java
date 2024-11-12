package Java_platform.Inheritance_polymorphism.InstanceOfTest0503;

//import Java_platform.Inheritance_polymorphism.InstanceOfTest0503.Grade;
import Java_platform.Inheritance_polymorphism.InstanceOfTest0503.Person;

import java.util.Objects;

public class Student extends Person {
    private String school;
    private Grade grade = Grade.FRESH;

    public Student(String name, int age, String address,String school){
        super(name,age,address);
        this.school = school;
    }

    public String getSchoolName() {return school;}

    public String getGrade() {return String.valueOf(grade.getYear());}

    @Override
    public String toString(){
        return String.format("%s %d %s %s",getName(),getAge(),getAddress(),school);
    }

    @Override
    public boolean equals(Object o){
        if (this == o ) return true;
        if(!(o instanceof Student)) return false;
        Student temp = (Student) o;
        return (Objects.equals(getName(),temp.getName())&&(Objects.equals(getAge(),temp.getAge()))&&(Objects.equals(getAddress(),temp.getAddress()))&&(Objects.equals(school,temp.school)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getAge(),getAddress(),school);
    }
}
