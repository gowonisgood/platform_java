package Java_platform.prepare_lab1;
import java.util.Scanner;

public class TypeMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printType(str);

        int a = Integer.parseInt(str);
        printType(a);
        float b = Float.parseFloat(str);
        printType(b);
        sc.close();
    }

    private static void printType(String x){
        System.out.println(x+" is a string");
    }

    private static void printType(int x){
        System.out.println(x+" is a int");
    }

    private static void printType(float x){
        System.out.println(x+" is a float");
    }

}
