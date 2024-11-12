package Java_platform.Inheritance_polymorphism.ReportGenerator0505;

public class Customer {
    private final String name;
    private int point;

    public Customer(String name, int point){
        this.name = name;
        this.point = point;
    }

    public final int getPoint(){
        return point;
    }

    public void setPoint(int Point){
        this.point = point;
    }

    public final String getName(){
        return name;
    }


}
