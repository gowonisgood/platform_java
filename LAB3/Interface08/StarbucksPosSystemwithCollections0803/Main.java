package StarbucksPosSystemwithCollections0803;

import StarbucksPosSystemwithCollections0803.app.Cafe;
import StarbucksPosSystemwithCollections0803.model.Customer;
import StarbucksPosSystemwithCollections0803.model.MenuItem;
import StarbucksPosSystemwithCollections0803.model.Order;
import StarbucksPosSystemwithCollections0803.service.ICafe;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Cafe
        ICafe cafe = new Cafe();

        // Menu Management
        System.out.println("----- Menu Management -----");
        MenuItem latte = new MenuItem("Latte", "Beverage", 4.50);
        MenuItem espresso = new MenuItem("Espresso", "Beverage", 3.00);
        MenuItem croissant = new MenuItem("Croissant", "Food", 3.50);
        MenuItem muffin = new MenuItem("Muffin", "Food", 2.75);
        MenuItem sandwich = new MenuItem("Sandwich", "Food", 5.00);

        // Add items to the menu
        cafe.addToMenu(latte);
        cafe.addToMenu(espresso);
        cafe.addToMenu(croissant);
        cafe.addToMenu(muffin);
        cafe.addToMenu(sandwich);

        // Attempt to add a duplicate item
        cafe.addToMenu(latte);

        // Display the menu
        cafe.displayMenu();

        // Update a menu item
        MenuItem almondCroissant = new MenuItem("Almond Croissant", "Food", 3.75);
        cafe.updateMenuItem(croissant, almondCroissant);

        // Remove a menu item
        cafe.removeFromMenu(espresso);

        // Display the updated menu
        cafe.displayMenu();

        // Customer Management
        System.out.println("\n----- Customer Management -----");
        Customer customer1 = new Customer("CUST001");
        Customer customer2 = new Customer("CUST002");
        Customer customer3 = new Customer("CUST003");

        // Record unique customers
        cafe.recordCustomer(customer1);
        cafe.recordCustomer(customer2);
        cafe.recordCustomer(customer3);

        // Attempt to record a duplicate customer
        cafe.recordCustomer(customer1);

        // Order Processing
        System.out.println("\n----- Order Processing -----");
        // Customer 1 places an order
        List<MenuItem> itemsOrdered1 = Arrays.asList(latte, almondCroissant);
        Order order1 = new Order(101, itemsOrdered1);
        cafe.placeOrder(order1);

        // Customer 2 places an order
        List<MenuItem> itemsOrdered2 = Arrays.asList(sandwich, muffin);
        Order order2 = new Order(102, itemsOrdered2);
        cafe.placeOrder(order2);

        // Display all current orders
        cafe.displayOrders();

        // Modify an order
        List<MenuItem> newItemsForOrder1 = Arrays.asList(latte, muffin);
        cafe.modifyOrder(101, newItemsForOrder1);

        // Cancel an order
        cafe.cancelOrder(102);

        // Display updated orders
        cafe.displayOrders();

        // Process the next order
        cafe.processNextOrder();

        // Attempt to process another order
        cafe.processNextOrder();

        // Attempt to process when no orders are left
        cafe.processNextOrder();

        // Sales Summary
        System.out.println("\n----- Sales Summary -----");
        // Update sales summary manually (if needed)
        // This is typically done during order processing

        // Display sales summary
        cafe.displaySalesSummary();

        // Generate daily sales report
        cafe.generateDailySalesReport();

        // Printing Receipts
        System.out.println("\n----- Printing Receipts -----");
        // Since order1 has been processed, we can print its receipt
        cafe.printReceipt(order1);

        // If we try to print a receipt for a canceled order
        cafe.printReceipt(order2);
    }
}


