package StarbucksPosSystemwithCollections0803.model;


public record MenuItem(String name, String type, double price) implements Comparable<MenuItem> {
    @Override
    public int compareTo(MenuItem other) {
        return this.name.compareTo(other.name);
    }
}

//public class MenuItem implements Comparable<MenuItem> {
//    private final String name;
//    private final String type;
//    private final double price;
//
//    public MenuItem(String name, String type, double price) {
//        this.name = name;
//        this.type = type;
//        this.price = price;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        MenuItem menuItem = (MenuItem) o;
//        return Objects.equals(name, menuItem.name) && Objects.equals(type, menuItem.type);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, type);
//    }
//
//    @Override
//    public int compareTo(MenuItem other) {
//        return this.name.compareTo(other.name);
//    }
//
//    @Override
//    public String toString() {
//        return name + " (" + type + ") - $" + price;
//    }
//}