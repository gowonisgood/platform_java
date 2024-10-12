package Java_platform.Inheritance_polymorphism.InstanceOfTest0503;

import Java_platform.Inheritance_polymorphism.InstanceOfTest0503.Person;

import java.util.Objects;

public class Professor extends Person {
    private String major;
    private String school;
    public Professor(String name, int age, String address,String school,String major){
        super(name,age,address);
        this.school = school;
        this.major = major;
    }

    public String schoolName() {return school;}

    public String major() {return major;}

    @Override
    public String toString(){
        return String.format("%s %d %s %s %s",getName(),getAge(),getAddress(),major,school);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o ) return true;
        if(!(o instanceof Professor)) return false;
        Professor temp = (Professor) o;
        return (Objects.equals(getName(),temp.getName())&&(Objects.equals(getAge(),temp.getAge()))&&(Objects.equals(getAddress(),temp.getAddress()))&&Objects.equals(major,temp.major)&&(Objects.equals(school,temp.school)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(),getAge(),getAddress(),school,major);
    }
}
