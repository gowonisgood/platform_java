package StarbucksPosSystemwithCollections0803.service;


import StarbucksPosSystemwithCollections0803.model.Customer;
import StarbucksPosSystemwithCollections0803.model.MenuItem;
import StarbucksPosSystemwithCollections0803.model.Order;

import java.util.List;

public interface ICafe {
    // Menu management
    void addToMenu(MenuItem item);
    void removeFromMenu(MenuItem item);
    void updateMenuItem(MenuItem oldItem, MenuItem newItem);
    void displayMenu();

    // Order management
    void placeOrder(Order order);
    Order findOrder(int orderId);
    void displayOrders();
    void processNextOrder();
    void modifyOrder(int orderId, List<MenuItem> newItems);
    void cancelOrder(int orderId);

    // Customer management
    void recordCustomer(Customer customer);

    // Sales summary
    void updateSalesSummary(MenuItem item);
    void displaySalesSummary();
    void generateDailySalesReport();

    // Receipts
    void printReceipt(Order order);
}
