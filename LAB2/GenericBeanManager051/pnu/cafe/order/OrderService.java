package Java_platform.GenericBeanManager051.pnu.cafe.order;
import Java_platform.GenericBeanManager051.pnu.cafe.core.*;
import Java_platform.GenericBeanManager051.pnu.cafe.menu.*;
import Java_platform.GenericBeanManager051.pnu.cafe.menu.Beverage;
import Java_platform.GenericBeanManager051.pnu.cafe.menu.Beverage.Size;
import java.util.ArrayList;
import java.util.List;

//import static Java_platform.CourseRegistration_033.edu.pnu.admin.EnrollmentTest.pnu;

public class OrderService extends Bean {
    private List<OrderItem> orderItems = new ArrayList<>();

    @Override
    public void initialize(){
        System.out.println("OrderService initialized.");
    }

    @Override
    public void destroy(){
        System.out.println("OrderService destroyed.");
    }

    public void add(OrderItem item){
        orderItems.add(item);
    }

    public int cost(){
        return orderItems.stream().mapToInt(OrderItem::getPrice).sum();
    }

    public void print(){
        for(OrderItem item : orderItems){
            System.out.println(item);
        }
    }

    public void setSize(String name, Beverage.Size size){
        boolean found = false;
        for(OrderItem item : orderItems){
            if(item.getBeverage().getName().equals(name)){
                if(item.getBeverage().setSize(size)){
                    System.out.println("Set Size to " + name+ "to"+ size);
                }
            } else{
                System.out.println("'Error: The size'"+size+"' is not available for the beverage '"+name+"'.");
            }
            return ;
        }
        if(!found){
            System.out.println("'Error: No such beverage found.");
        }
    }

}
