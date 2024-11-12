package StarbucksPosSystemwithCollections0803.app;
// Implement your code
import StarbucksPosSystemwithCollections0803.service.ICafe;
import StarbucksPosSystemwithCollections0803.model.MenuItem;
import StarbucksPosSystemwithCollections0803.model.Order;
import StarbucksPosSystemwithCollections0803.model.Customer;

import java.text.DecimalFormat;
import java.util.Comparator;

import java.lang.reflect.Method;
import java.util.*;

public class Cafe implements ICafe {
    // Data structures
    private Set<MenuItem> menu = new LinkedHashSet<>();
    private Queue<Order> orderQueue = new LinkedList<>();
    private Set<Customer> uniqueCustomers = new HashSet<>();
    private Map<Integer, Order> orderMap = new HashMap<>();
    private Map<MenuItem, Integer> salesSummary = new HashMap<>();

    //0.소숫점 출력을 위한
    public String decimalFormat(double num){
        DecimalFormat df = new DecimalFormat("#.0#");
        return df.format(num);
    }

    //1.Menu Management
    public void addToMenu(MenuItem item){
        boolean isAdded = menu.add(item);
        if(!isAdded){
            System.out.println("Item already exists in the menu.");
        }
    }

    public void removeFromMenu(MenuItem item){
        menu.remove(item);
        System.out.println("Menu item removed.");
    }

    public void updateMenuItem(MenuItem oldItem, MenuItem newItem){
        menu.remove(oldItem);
        menu.add(newItem);
        System.out.println("Menu item updated.");
    }

    public void displayMenu(){
        List<MenuItem> sortedMenu = new ArrayList<>(menu);
        sortedMenu.sort(Comparator.comparing(MenuItem::type)
                .thenComparing(MenuItem::name)); // name, type 기준으로 정렬
        System.out.println("Menu:");
        for (MenuItem item : sortedMenu) {
            System.out.printf("MenuItem[name=%s, type=%s, price=%s]\n", item.name(), item.type(), decimalFormat(item.price()));
        }
    }

    //2.Order Processing
    public void placeOrder(Order order){
        orderQueue.add(order);
        orderMap.put(order.getOrderId(), order);
        System.out.printf("Order placed: Order ID:%d, ",order.getOrderId());
        List<MenuItem> items = order.getItems();
        int size = items.size();
        System.out.print("Items: ");
        for(int i = 0; i < size; i++){
            if(i==0) System.out.print("[");
            else System.out.print(" ");

            MenuItem item = items.get(i);
            System.out.printf("MenuItem[name=%s, type=%s, price=%s]", item.name(), item.type(), decimalFormat(item.price()));
            if(i < size - 1){
                System.out.print(",");
            }
        }
        System.out.print("]\n");
    }

    public Order findOrder(int orderId){
        for(Order order : orderMap.values()){
            if(order.getOrderId() == orderId){
                return order;
            }
        }
        return null;
    }

    public void displayOrders(){
        System.out.println("Current Orders:");
        for(Order order : orderQueue){
            System.out.printf("Order ID: %d, ",order.getOrderId());
            System.out.print("Items: [");
            List<MenuItem> items = order.getItems();
            int size = items.size();
            for(int i = 0; i < size; i++){
                MenuItem item = items.get(i);
                System.out.printf("MenuItem[name=%s, type=%s, price=%s]", item.name(), item.type(), decimalFormat(item.price()));
                if(i < size - 1){
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }
    }

    public void processNextOrder(){
        try {
            Order od = orderQueue.poll();
            orderMap.remove(od.getOrderId());
            System.out.println("Processed Order: Order ID: " + od.getOrderId());
            System.out.print("Items: [");
            List<MenuItem> items = od.getItems();
            int size = items.size();
            for(int i = 0; i < size; i++){
                MenuItem item = items.get(i);
                updateSalesSummary(item); //할때 마다 추가
                System.out.printf("MenuItem[name=%s, type=%s, price=%s]", item.name(), item.type(), decimalFormat(item.price()));
                if(i < size - 1){
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }catch(Exception e){
            System.out.println("No orders to process.");
        }
    }

    public void modifyOrder(int orderId, List<MenuItem> newItems){

        //1. orderId로 order을 찾아서 없앤다.
        Order od = findOrder(orderId);
        /*orderQueue.remove(od);
        orderMap.remove(od.getOrderId(), od);

        //2.새 Order을 넣는다.
        Order newOrder = new Order(orderId,newItems);
        orderQueue.add(newOrder);
        orderMap.put(newOrder.getOrderId(), newOrder);*/
        //2. 새 order로 교체한다.
        od.setItems(newItems);

        //3.Print
        System.out.printf("Order updated: Order ID:%d,",od.getOrderId());
        System.out.print(" Items: ");
        List<MenuItem> items = od.getItems();
        int size = items.size();
        for(int i = 0; i < size; i++){
            if(i==0) System.out.print("[");
            else System.out.print(" ");

            MenuItem item = items.get(i);
            System.out.printf("MenuItem[name=%s, type=%s, price=%s]", item.name(), item.type(), decimalFormat(item.price()));
            if(i < size - 1){
                System.out.print(",");
            }
        }
        System.out.print("]\n");

    }

    public void cancelOrder(int orderId){
        System.out.printf("Order canceled: Order ID:%d,",orderId);
        Order od = findOrder(orderId);
        List<MenuItem> items = od.getItems();
        int size = items.size();
        System.out.print(" Items: ");
        for(int i = 0; i < size; i++){
            if(i==0) System.out.print("[");
            else System.out.print(" ");

            MenuItem item = items.get(i);
            System.out.printf("MenuItem[name=%s, type=%s, price=%s]", item.name(), item.type(), decimalFormat(item.price()));
            if(i < size - 1){
                System.out.print(",");
            }
        }
        System.out.print("]\n");


        orderQueue.remove(od);
        orderMap.remove(orderId);
    }

    //3.Customer Management

    public static int uniqueId = 1;
    public void recordCustomer(Customer customer){
        if(uniqueCustomers.contains(customer)){
            System.out.println("Customer already exists.");
        }
        else{
            uniqueCustomers.add(customer);
            System.out.printf("Customer recorded: Customer[customerId=CUST00%d]\n",uniqueId++);
        }
    }


    //4.Sales Summary
    public void updateSalesSummary(MenuItem item){
        salesSummary.put(item, salesSummary.getOrDefault(item, 0) + 1);
    }

    public void displaySalesSummary(){
        System.out.println("Sales Summary:");

        /*for(MenuItem item : salesSummary.keySet()){
            System.out.printf("MenuItem[name=%s, type=%s, price=%s] sold: %d times\n",item.name(),item.type(),decimalFormat(item.price()),salesSummary.get(item));
        }*/

        for (Map.Entry<MenuItem, Integer> entry : salesSummary.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("MenuItem[name=%s, type=%s, price=%s] sold: %d times\n",
                    item.name(), item.type(), decimalFormat(item.price()), quantity);

        }

    }

    public void generateDailySalesReport(){
        System.out.println("Daily Sales Report:");
        double sum = 0.0;
        int totalItemSold = 0;
        for(MenuItem item : salesSummary.keySet()){
            double price = item.price();
            double Q = (double)salesSummary.get(item);
            double Revenue = price*Q;
            System.out.printf("MenuItem[name=%s, type=%s, price=%s] - Quantity: %d, Revenue: $%s\n",item.name(),item.type(),decimalFormat(item.price()),salesSummary.get(item),decimalFormat(Revenue));
            sum+=Revenue;
            totalItemSold += salesSummary.get(item);
        }
        System.out.printf("Total items sold: %d\n",totalItemSold);
        System.out.println("Total revenue: $"+sum);
    }

    //5.Receipts
    public void printReceipt(Order order){
        double sum = 0;
        System.out.printf("Receipt for Order ID: %d\n",order.getOrderId());
        List<MenuItem> items = order.getItems();
        for(MenuItem item : items){
            System.out.printf("%s - $%s\n",item.name(),decimalFormat(item.price()));
            sum+=item.price();
        }
        System.out.printf("Total: $%s\n",decimalFormat(sum));
    }
}
