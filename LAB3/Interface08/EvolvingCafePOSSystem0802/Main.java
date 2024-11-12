package EvolvingCafePOSSystem0802;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Orderable pos = new SimplePOS();

        createOrderV1(pos); //By 20230331
        createOrderV2(pos); //By 20231231
        createOrderV3(pos); //By 20240430
        createOrderV4(pos); //By 20241031
    }

    private static void createOrderV1(Orderable pos) {
        System.out.println("=== Version 1 Orders ===");
        pos.placeOrder("Espresso");
        System.out.println();
    }

    private static void createOrderV2(Orderable pos) {
        System.out.println("=== Version 2 Orders ===");
        pos.placeOrder("Caffe Latte");
        pos.placeOrder("Cappuccino", "Grande");
        System.out.println();
    }

    private static void createOrderV3(Orderable pos) {
        System.out.println("=== Version 4 Orders ===");
        LocalDate dateInDecember = LocalDate.of(2023, Month.DECEMBER, 15);
        LocalDate dateInJuly = LocalDate.of(2023, Month.JULY, 10);
        LocalDate today = LocalDate.now();

        double discount = pos.getSeasonalDiscount(dateInDecember);
        System.out.println(dateInDecember + " Seasonal Discount: " + (discount * 100) + "%");
        discount = pos.getSeasonalDiscount(dateInJuly);
        System.out.println(dateInJuly + " Seasonal Discount: " + (discount * 100) + "%");
        discount = pos.getSeasonalDiscount(today);
        System.out.println(today + " Seasonal Discount: " + (discount * 100) + "%");
        System.out.println();

    }

    private static void createOrderV4(Orderable pos) {
        System.out.println("=== Version 4 Orders ===");
        if (Orderable.isAvailable("Espresso")){
            pos.placeOrder("Espresso");
        }
        System.out.println();
    }

}