package Java_platform.GenericBeanManager051.pnu.cafe;
import Java_platform.GenericBeanManager051.pnu.cafe.menu.*;
import Java_platform.GenericBeanManager051.pnu.cafe.order.*;
import Java_platform.GenericBeanManager051.pnu.cafe.core.Bean;
import Java_platform.GenericBeanManager051.pnu.cafe.core.BeanInitializer;
import Java_platform.GenericBeanManager051.pnu.cafe.core.BeanManager;

import java.util.Scanner;
enum Command {ADD, COST, SIZE, PRINT, QUIT, INVALID}

public class OrderTest {
    private static BeanInitializer beanManager = new BeanInitializer();
    private static OrderService orderService;

    public static void main(String[] args) {
        new BeanInitializer(beanManager);
        orderService = beanManager.getOrCreateBean(OrderService.class);

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            final Command cmd = getCommand(scanner);
            if (cmd == Command.QUIT) {
                System.out.println("Bye");
                break;
            }
            if (cmd == Command.INVALID) {
                System.out.println("Invalid Operation!");
                continue;
            }
            switch (cmd) {
                case ADD:
                    final OrderItem item = createOrderItem(scanner);
                    System.out.println("Added to order: " + item);
                    orderService.add(item);
                    break;
                case COST:
                    System.out.printf("Total Cost: %,d%n", orderService.cost());
                    break;
                case SIZE:
                    final String name = scanner.next();
                    final Beverage.Size size = Beverage.Size.valueOf(scanner.next().toUpperCase());
                    orderService.setSize(name, size);
                    break;
                case PRINT:
                    System.out.println("\n--- PNU Cafe Receipt ---");
                    orderService.print();
                    System.out.printf("Total: %,d%n", orderService.cost());
                    System.out.println("------------------------\n");
                    break;
                default:
                    break;
            }
        }
        scanner.close();
        beanManager.close();
    }

    private static OrderItem createOrderItem(final Scanner scanner) {
        final String type = scanner.next();
        final String name = scanner.next();
        final int quantity = scanner.nextInt();

        Beverage beverage = Beverage.Factory.createBeverage(type, name);
        return new OrderItem(beverage, quantity);
    }

    private static Command getCommand(final Scanner scanner) {
        final String operation = scanner.next();
        try {
            return Command.valueOf(operation.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Command.INVALID;
        }
    }
}