package StarbucksPosSystemwithCollections0803.model;

import java.util.List;
import java.util.Objects;

public class Order {
    private int orderId;
    private List<MenuItem> items;

    public Order(int orderId, List<MenuItem> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Items: " + items;
    }

    public void setItems(List<MenuItem> newItems) {
        this.items = newItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}


