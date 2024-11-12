package Java_platform.PNUCafeOrderingSystem.pnu.cafe;
import Java_platform.PNUCafeOrderingSystem.pnu.cafe.menu.Beverage;
import Java_platform.PNUCafeOrderingSystem.pnu.cafe.order.Order;
import Java_platform.PNUCafeOrderingSystem.pnu.cafe.order.OrderItem;
import java.util.Scanner;

enum Command {ADD, COST, SIZE, PRINT, QUIT, INVALID}

public class OrderTest {
    private static Order order = new Order();

    public static void main(String[] args) {
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
                    order.add(item);
                    break;
                case COST:
                    System.out.printf("Total Cost: %,d%n", order.cost());
                    break;
                case SIZE:
                    final String name = scanner.next();
                    final Beverage.Size size = Beverage.Size.valueOf(scanner.next().toUpperCase());
                    order.setSize(name, size);
                    break;
                case PRINT:
                    System.out.println("\n--- PNU Cafe Receipt ---");
                    order.print();
                    System.out.printf("Total: %,d%n", order.cost());
                    System.out.println("------------------------\n");
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }

    private static Command getCommand(final Scanner scanner) {
        final String operation = scanner.next();

        Command kind;
        try {
            kind = Command.valueOf(operation.toUpperCase());
        } catch (IllegalArgumentException e) {
            kind = Command.INVALID;
        }
        return kind;
    }

    private static OrderItem createOrderItem(final Scanner scanner) {
        final String type = scanner.next();
        final String name = scanner.next();
        final int quantity = scanner.nextInt();

        Beverage beverage = Beverage.Factory.createBeverage(type, name);
        return new OrderItem(beverage, quantity);
    }
}
