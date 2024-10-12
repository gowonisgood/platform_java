package Java_platform.Inheritance_polymorphism;

public class Student {
    String id;
    String name;
    String email;

    public Student(String Id, String Name, String Email){
        this.id = Id;
        this.name = Name;
        this.email = Email;
    }

    @Override
    public String toString(){
        return String.format("Student ID:%s, Name:%s, Email:%s",id,name,email);
    }
}
