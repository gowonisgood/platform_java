package StarbucksPosSystemwithCollections0803.model;

public record Customer(String customerId) {
    // No need to override equals, hashCode, or toString
}

//public class Customer {
//    private final String customerId;
//
//    public Customer(String customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerId() {
//        return customerId;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Customer customer = (Customer) obj;
//        return customerId.equals(customer.customerId);
//    }
//
//    @Override
//    public int hashCode() {
//        return customerId.hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return "Customer ID: " + customerId;
//    }
//}