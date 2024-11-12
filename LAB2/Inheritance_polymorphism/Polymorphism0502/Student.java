package Java_platform.Inheritance_polymorphism.Polymorphism0502;

import java.util.Objects;

public class Student extends Person{
    private String school;
    private Grade grade = new Grade();

    public Student(String name, int age, String address,String school){
        super(name,age,address);
        this.school = school;
    }

    @Override
    public String toString(){
        return String.format("%s %d %s %s",name,age,address,school);
    }

    @Override
    public boolean equals(Object o){
        if (this == o ) return true;
        if(!(o instanceof Student)) return false;
        Student temp = (Student) o;
        return (Objects.equals(name,temp.name)&&(Objects.equals(age,temp.age))&&(Objects.equals(address,temp.address))&&(Objects.equals(school,temp.school)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age,address,school);
    }
}
