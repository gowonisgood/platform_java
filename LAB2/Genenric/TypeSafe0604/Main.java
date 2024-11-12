package Java_platform.Genenric.TypeSafe0604;
import java.lang.Object;
import java.lang.Integer;
import java.lang.String;
import java.lang.Double;

public class Main {
    public static void main(String[] args) {
        BeanManager beanManager = new BeanManager();

        beanManager.addBean(Integer.class, 42);
        beanManager.addBean(String.class, "Hello, World!");
        beanManager.addBean(Double.class, 3.14159);

        Integer integer = beanManager.getBean(Integer.class);
        String str = beanManager.getBean(String.class);
        Double my_double = beanManager.getBean(Double.class);

        integer += 5;
        str = str.toUpperCase();
        my_double *= 2;

        System.out.println("Integer after addition: " + integer);
        System.out.println("String in uppercase: " + str);
        System.out.println("Double after multiplication: " + my_double);
    }
}