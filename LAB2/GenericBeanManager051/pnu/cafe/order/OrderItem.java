package Java_platform.GenericBeanManager051.pnu.cafe.order;
import Java_platform.GenericBeanManager051.pnu.cafe.menu.Beverage;

//import Java_platform.PNUCafeOrderingSystem.pnu.cafe.menu.Beverage;

public class OrderItem {
    private Beverage beverage;
    private int quantity;

    public OrderItem(Beverage beverage, int quantity) {
        this.beverage = beverage;
        this.quantity = quantity;
    }

    public Beverage getBeverage() {
        return this.beverage;
    }

    public int getPrice(){
        return this.beverage.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return beverage.toString()+" x "+quantity;
    }
}
