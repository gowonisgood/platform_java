package Java_platform.MyScanner;

public class TestMyScanner {
    public static void main(String[] args) {
        String input = "123 abc 45.67 def -456\nHello world!";

        MyScanner scanner = new MyScanner(input);

        System.out.println("Next Int: " + scanner.nextInt());
        System.out.println("Next Token: " + scanner.next());
        System.out.println("Next Double: " + scanner.nextDouble());
        System.out.println("Next Token: " + scanner.next());
        System.out.println("Next Int: " + scanner.nextInt());
        scanner.nextLine();
        System.out.println("Next Line: " + scanner.nextLine());
    }
}
