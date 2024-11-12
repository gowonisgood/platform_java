package Java_platform.PNUCafeOrderingSystem.pnu.cafe.order;
import Java_platform.PNUCafeOrderingSystem.pnu.cafe.menu.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.sum;

public class Order {
    private List<OrderItem> items = new ArrayList<>();

    public void add(OrderItem item) {
        items.add(item);
    }

    public int cost(){
        return items.stream().mapToInt(OrderItem::getPrice).sum();
    }

    public void print(){
        for(OrderItem item : items){
            System.out.println(item.toString());
        }
    }

    public void setSize(String name, Beverage.Size size){
        boolean found = false;
        for(OrderItem item : items){
            if(item.getBeverage().getName().equalsIgnoreCase(name)){
                found = true;
                if(item.getBeverage().setSize(size)) {
                    System.out.println("Size updated for " + name + " to " + size);
                }
            }else{
                System.out.println("Error: The size '"+size+"' is not available for the beverage '"+name+"'.");
            }
            return;
        }
        if(!found) {
            System.out.println("Error: No such beverage found.");
        }
    }
}
