package Java_platform.Inheritance_polymorphism.Polymorphism0502;

import java.util.Objects;

public class Professor extends Person {
    private String major;
    private String school;
    public Professor(String name, int age, String address,String school,String major){
        super(name,age,address);
        this.school = school;
        this.major = major;
    }

    @Override
    public String toString(){
        return String.format("%s %d %s %s %s",name,age,address,school,major);
    }

    @Override
    public boolean equals(Object o){
        if (this == o ) return true;
        if(!(o instanceof Professor)) return false;
        Professor temp = (Professor) o;
        return (Objects.equals(name,temp.name)&&(Objects.equals(age,temp.age))&&(Objects.equals(address,temp.address))&&(Objects.equals(major,temp.major)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age,address,major);
    }
}
