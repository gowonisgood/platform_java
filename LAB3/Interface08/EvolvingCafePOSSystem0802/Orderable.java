package EvolvingCafePOSSystem0802;

// Implement your code

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

public interface Orderable {

    Map<String,String> menu = new HashMap<String,String>();

    void placeOrder(String drinkName);

    default void placeOrder(String drinkName, String size) {
        menu.put(drinkName,size);
        System.out.println(size + " " + drinkName);
    }

    default double getSeasonalDiscount(LocalDate date){
        Month month = date.getMonth();
        switch (month) {
            case MARCH:
                return 0.0;
            case JULY:
                return 0.1;
            case DECEMBER:
                return 0.2;
            default:
                return 0.0;
        }
    }

    static boolean isAvailable(String drinkName) {
        String[] availableDrinks = {"Espresso", "Caffe Latte", "Cappuccino"};
        for (String drink : availableDrinks) {
            if (drink.equals(drinkName)) {
                return true;
            }
        }
        return false;

        /*for(String m: menu.keySet()){
            if (m.equals(drinkName)) {
                return true;
            }
        }*/
    }
}

