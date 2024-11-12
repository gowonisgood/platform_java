package EvolvingCafePOSSystem0802;

public class SimplePOS implements Orderable {
    @Override
    public void placeOrder(String drinkName) {
        System.out.println("Order placed: " + drinkName);
    }
}