package Java_platform.Inheritance_polymorphism.InstanceOfTest0503;
import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {return name;}
    public String getAddress() {return address;}
    public int getAge() {return age;}

    @Override
    public String toString(){
        return String.format("%s %d %s",name,age,address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o ) return true;
        if(!(o instanceof Person))return false;
        //1.typecasting
        Person temp = (Person) o;
        return (Objects.equals(name,temp.name)&&(Objects.equals(age,temp.age))&&(Objects.equals(address,temp.address)));
    }


    @Override
    public int hashCode() {
        return Objects.hash(name,age,address);
    }


}
