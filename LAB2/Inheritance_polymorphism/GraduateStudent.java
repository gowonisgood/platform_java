package Java_platform.Inheritance_polymorphism;

public class GraduateStudent extends Student{

    String title;
    public GraduateStudent(String Id, String Name, String Email, String Title){
        super(Id,Name,Email);
        this.title = Title;
    }
    @Override
    public String toString(){
        return String.format("Student ID:%s, Name:%s, Email:%s, Thesis Title:%s",id,name,email,title);
    }
}

