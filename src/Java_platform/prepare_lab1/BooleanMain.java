package Java_platform.prepare_lab1;
import java.util.Scanner;

public class BooleanMain {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();

        System.out.printf("Number:%d, Number2:%d\n", a,b);
        System.out.printf("Number1>Number2?%b\n",a>b );
        System.out.printf("Number1<Number2?%b\n", a<b);
        System.out.printf("Number=Number2?%b\n", a==b);
    }

}
