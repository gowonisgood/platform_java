package Java_platform.Class_overloading.EqualsAndHashCode;
import java.util.Objects;
public class Employee {
    //Your code here - 멤버 변수를 정의하시오
    private final String name;
    private final Double salary;

    //Your code here - 생성자를 정의하시오
    public Employee(String n, Double s){
        this.name = n;
        this.salary = s;
    }

    public String getName() {
        //Your code here
        return name;
    }

    public Double getSalary() {
        //Your code here
        return salary;
    }

    @Override
    public String toString() {
        //Your code here
        return String.format("%s %.1f",name,salary);
    }

    @Override
    public boolean equals(Object o) {
        //Your code here
        if (this == o ) return true;
        if(!(o instanceof Employee)) return false;
        //1.typecasting
        Employee temp = (Employee) o;
        return (Objects.equals(name,temp.name)&&(Objects.equals(salary,temp.salary)));
    }


    @Override
    public int hashCode() {
        //Your code here
        return Objects.hash(name,salary);
    }

}
