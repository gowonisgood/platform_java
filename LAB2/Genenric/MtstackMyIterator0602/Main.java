package Java_platform.Genenric.MtstackMyIterator0602;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);
        intStack.push(6);
        List<Integer> nums = Arrays.asList(7, 8, 9);
        intStack.pushAll(nums);

        System.out.println("Popped: " + intStack.pop());
        System.out.println("Current size of intStack: " + intStack.size());

        System.out.println("Iterating through intStack:");
        Stack<Integer> it = intStack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Java");
        stringStack.push("Python");
        stringStack.push("C++");

        System.out.println("Popped: " + stringStack.pop());
        System.out.println("Current size of stringStack: " + stringStack.size());

        System.out.println("Iterating through stringStack:");
        Stack<String> it2 = stringStack.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}
