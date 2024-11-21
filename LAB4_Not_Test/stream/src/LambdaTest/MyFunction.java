package LambdaTest;

@FunctionalInterface
public interface MyFunction {
    // Abstract method for functional interface
    void run();

    // Static method to create MyFunction instance
    static MyFunction getMyFunction(String name) {
        return () -> System.out.println(name + ".run()");
    }

    // Default method
    default void sayHello() {
        System.out.println("Hello");
    }
}